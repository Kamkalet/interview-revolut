package com.example.currencieslist.rates

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import java.math.BigDecimal
import javax.inject.Inject

class RatesPresenter @Inject constructor(
    private val interactor: RatesInteractor,
    private val imageResolver: ImageResolver
) {

    private var disposables = CompositeDisposable()

    fun attach(view: RatesView) {
        view.apply {
            initRatesList()

            interactor.ratesStream
                .map { toRatesModelList(it) }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    if (it.isEmpty()) {
                        setProgressVisibility(false)
                        setErrorVisibility(true)
                        setRatesVisibility(false)
                    } else {
                        setRatesVisibility(true)
                        setErrorVisibility(false)
                        setProgressVisibility(false)
                        setRatesItemList(it)
                    }
                }
                .addTo(disposables)
        }
    }

    private fun toRatesModelList(ratesEvent: RatesEvent): List<Rate> {
        return when (ratesEvent) {
            is RatesEvent.Value -> {
                ratesEvent.rates.run {
                    val rates = mutableListOf(base)
                    rates.addAll(
                        ratesMap.map {
                            Rate(
                                code = it.key,
                                value = it.value,
                                resource = imageResolver.resolve(it.key)
                            )
                        })
                    return rates
                }
            }
            else -> emptyList()
        }

    }

    fun detach() {
        disposables.clear()
    }
}

data class Rate(
    val code: String,
    var value: BigDecimal,
    val resource: RateResource
)

interface RatesView {
    fun setRatesItemList(rates: List<Rate>)
    fun initRatesList()
    fun setErrorVisibility(visible: Boolean)
    fun setProgressVisibility(visible: Boolean)
    fun setRatesVisibility(visible: Boolean)
}
