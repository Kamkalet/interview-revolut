package com.example.currencieslist.rates

import com.example.currencieslist.di.ApplicationScope
import com.example.currencieslist.rates.network.RatesGateway
import io.reactivex.Observable
import io.reactivex.rxkotlin.Observables
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import timber.log.Timber
import java.math.BigDecimal
import java.math.RoundingMode
import java.util.concurrent.TimeUnit
import javax.inject.Inject

private val DEFAULT_BASE = Rate("EUR", BigDecimal.ONE, RateResource.EUR)

@ApplicationScope
class RatesInteractor @Inject constructor(
    private val gateway: RatesGateway
) {

    private var baseSubject = BehaviorSubject.createDefault<Rate>(DEFAULT_BASE)
    private val multiplierSubject = PublishSubject.create<BigDecimal>()

    val ratesStream: Observable<RatesEvent> =
        Observables.combineLatest(
            Observable.interval(0, 1, TimeUnit.SECONDS),
            baseSubject
        ) { _, base -> base }
            .subscribeOn(Schedulers.io())
            .switchMap { base ->
                Observables.combineLatest(
                    gateway.getCurrencies(base.code).toObservable(),
                    multiplierSubject.startWith(base.value)
                ) { rates, multiplier -> rates to multiplier }
                    .subscribeOn(Schedulers.io())
                    .map { mapToModel(it.first.rates, base, it.second) }
                    .onErrorResumeNext { t: Throwable ->
                        Timber.tag("RatesError").e(t)
                        Observable.just(RatesEvent.Error(t))
                    }
            }
            .replay(1)
            .refCount()

    fun changeBase(newBase: Rate) {
        baseSubject.onNext(newBase)
    }

    fun applyMultiplier(multiplier: BigDecimal) {
        multiplierSubject.onNext(multiplier)
    }

    private fun mapToModel(rates: LinkedHashMap<String, String>, base: Rate, multiplier: BigDecimal) =
        RatesEvent.Value(
            rates = Rates(
                base = base,
                ratesMap = multiplyWithUserInput(rates, multiplier) as LinkedHashMap<String, BigDecimal>
            )
        ) as RatesEvent

    private fun multiplyWithUserInput(rates: LinkedHashMap<String, String>, multiplier: BigDecimal) =
        rates.mapValues { entry ->
            entry.value.toBigDecimal()
                .multiply(multiplier)
                .setScale(2, RoundingMode.HALF_UP)
                .stripTrailingZeros()
        }
}

sealed class RatesEvent {

    data class Value(val rates: Rates) : RatesEvent()
    data class Error(val throwable: Throwable) : RatesEvent()
}

data class Rates(
    val base: Rate,
    val ratesMap: LinkedHashMap<String, BigDecimal>
)