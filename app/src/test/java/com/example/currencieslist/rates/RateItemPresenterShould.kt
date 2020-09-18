package com.example.currencieslist.rates

import com.example.currencieslist.R
import com.nhaarman.mockitokotlin2.*
import io.reactivex.Observable
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.math.BigDecimal

internal class RateItemPresenterShould {

    private val interactor: RatesInteractor = mock {}
    private val presenter = RateItemPresenter(interactor)

    private val view: RateItemView = mock()

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
    fun `set rate on bind`() {
        given(interactor.ratesStream).willReturn {
            Observable.just(ratesEvent)
        }
        presenter.onBind(view, rate, 0)

        verify(view).setFlag(R.drawable.ic_pln)
        verify(view).setCurrencyCode("PLN")
        verify(view).setRateDescription(R.string.pln_desc)
        verify(view).setRateText(1.toBigDecimal().toPlainString())
    }

    @Test
    fun `set empty string when value equals zero`() {
        given(interactor.ratesStream).willReturn {
            Observable.just(ratesEvent)
        }
        presenter.onBind(view, Rate("PLN", BigDecimal.ZERO, RateResource.PLN), 0)

        verify(view).setRateText("")
    }

    @Test
    fun `init text watcher when first on list`() {
        given(interactor.ratesStream).willReturn {
            Observable.just(ratesEvent)
        }
        presenter.onBind(view, Rate("PLN", BigDecimal.ZERO, RateResource.PLN), 0)

        verify(view).initTextWatcher()
    }

    @Test
    fun `init focus listener when not first`() {
        given(interactor.ratesStream).willReturn {
            Observable.just(ratesEvent)
        }
        presenter.onBind(view, Rate("PLN", BigDecimal.ZERO, RateResource.PLN), 5)

        verify(view).initOnEditTextClickListener()
    }

    @Test
    fun `not update values from stream when first on list`() {
        given(interactor.ratesStream).willReturn {
            Observable.just(ratesEvent)
        }
        presenter.onBind(view, Rate("PLN", BigDecimal.ONE, RateResource.PLN), 0)

        verify(view, times(1)).setRateText("1")
    }

    @Test
    fun `not update values when error`() {
        given(interactor.ratesStream).willReturn(Observable.just(RatesEvent.Error(Throwable())))
        presenter.onBind(view, Rate("PLN", BigDecimal.ONE, RateResource.PLN), 1)

        verify(view, times(1)).setRateText("1")
    }

    @Test
    fun `change base using latest rate base`() {
        given(interactor.ratesStream).willReturn { Observable.just(ratesEvent) }

        presenter.onBind(
            view,
            Rate("EUR", 55555.toBigDecimal().stripTrailingZeros(), RateResource.EUR),
            1
        )
        presenter.onRateGainedFocus()

        verify(interactor).changeBase(Rate("EUR", 0.27.toBigDecimal().stripTrailingZeros(), RateResource.EUR))
    }

    @Test
    fun `apply multiplier on input changed`() {
        given(interactor.ratesStream).willReturn { Observable.just(ratesEvent) }

        presenter.onBind(
            view,
            ratesEvent.rates.base,
            0
        )
        presenter.onRateInputChanged("2")

        verify(interactor).applyMultiplier(2.toBigDecimal())
    }

    private companion object {

        val rate = Rate(
            "PLN",
            BigDecimal.ONE.stripTrailingZeros(),
            RateResource.PLN
        )
        val ratesEvent = RatesEvent.Value(
            Rates(
                base = Rate(
                    "PLN",
                    BigDecimal.ONE,
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