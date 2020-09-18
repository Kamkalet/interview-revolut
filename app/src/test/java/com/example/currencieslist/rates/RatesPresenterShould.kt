package com.example.currencieslist.rates

import com.nhaarman.mockitokotlin2.*
import io.reactivex.Observable
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class RatesPresenterShould {

    private val interactor: RatesInteractor = mock {}
    private val ratesPresenter = RatesPresenter(interactor, ImageResolver())

    private val view: RatesView = mock()

    @BeforeEach
    fun overrideSchedulers() {
        RxAndroidPlugins.reset()
        RxJavaPlugins.reset()

        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
    }

    @AfterEach
    fun resetSchedulers() {
        RxAndroidPlugins.reset()
        RxJavaPlugins.reset()
    }

    @Test
    fun `init recycler view on attach`() {
        given(interactor.ratesStream).willReturn { Observable.just(RatesEvent.Error(Throwable())) }
        ratesPresenter.attach(view)

        verify(view).initRatesList()
    }

    @Test
    fun `set error states on error returned`() {
        given(interactor.ratesStream).willReturn { Observable.just(RatesEvent.Error(Throwable())) }
        ratesPresenter.attach(view)

        verify(view).setErrorVisibility(true)
        verify(view).setProgressVisibility(false)
        verify(view).setRatesVisibility(false)
    }


    @Test
    fun `set proper states on event return`() {
        given(interactor.ratesStream).willReturn {
            Observable.just(
                ratesEvent
            )
        }
        ratesPresenter.attach(view)

        verify(view).setErrorVisibility(false)
        verify(view).setProgressVisibility(false)
        verify(view).setRatesVisibility(true)
    }

    @Test
    fun `set rates model on rates event return`() {
        given(interactor.ratesStream).willReturn {
            Observable.just(
                ratesEvent
            )
        }
        ratesPresenter.attach(view)

        verify(view).setRatesItemList(
            listOf(
                Rate(
                    "PLN",
                    435.toBigDecimal().stripTrailingZeros(),
                    RateResource.PLN
                ),
                Rate(
                    "EUR",
                    0.27.toBigDecimal().stripTrailingZeros(),
                    RateResource.EUR
                ),
                Rate(
                    "CHF",
                    0.24.toBigDecimal().stripTrailingZeros(),
                    RateResource.CHF
                )
            )
        )
    }

    @Test
    fun `dispose of stream on view detach`() {
        val subject = BehaviorSubject.create<RatesEvent>()
        given(interactor.ratesStream).willReturn { subject }
        ratesPresenter.attach(view)
        subject.onNext(ratesEvent)
        verify(view).setErrorVisibility(false)
        verify(view).setProgressVisibility(false)
        verify(view).setRatesVisibility(true)

        reset(view)
        ratesPresenter.detach()
        subject.onNext(ratesEvent)

        verifyNoMoreInteractions(view)
    }

    private companion object {

        val ratesEvent = RatesEvent.Value(
            Rates(
                base = Rate(
                    "PLN",
                    435.toBigDecimal().stripTrailingZeros(),
                    RateResource.PLN
                ),
                ratesMap = linkedMapOf(
                    "EUR" to 0.27.toBigDecimal().stripTrailingZeros(),
                    "CHF" to 0.24.toBigDecimal().stripTrailingZeros()
                )
            )
        )
    }
}