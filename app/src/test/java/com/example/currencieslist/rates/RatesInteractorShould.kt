package com.example.currencieslist.rates

import com.example.currencieslist.rates.network.RatesGateway
import com.example.currencieslist.rates.network.RatesResponse
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.TestScheduler
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.util.concurrent.TimeUnit


class RatesInteractorShould {

    private val scheduler = TestScheduler()
    private val gateway: RatesGateway = mock {
        on { getCurrencies("EUR") } doReturn Single.just(eurRatesResponse)
        on { getCurrencies("PLN") } doReturn Single.just(plnRatesResponse)
    }

    @BeforeEach
    fun overrideSchedulers() {
        RxAndroidPlugins.reset()
        RxJavaPlugins.reset()

        RxJavaPlugins.setIoSchedulerHandler { scheduler }
        RxJavaPlugins.setComputationSchedulerHandler { scheduler }
    }

    @AfterEach
    fun resetSchedulers() {
        RxAndroidPlugins.reset()
        RxJavaPlugins.reset()
    }

    @Test
    fun `return rates error event on error`() {
        val throwable = Error()
        whenever(gateway.getCurrencies("EUR")).thenReturn(Single.error(throwable))
        val testObserver = givenInteractor().ratesStream.test()

        scheduler.triggerActions()

        testObserver.assertValue(RatesEvent.Error(throwable))
    }

    @Test
    fun `return initial rates for eur`() {
        val testObserver = givenInteractor().ratesStream.test()

        scheduler.triggerActions()

        testObserver.assertValue(RatesEvent.Value(expectedInitialEurRates))
    }

    @Test
    fun `return next rates after some time`() {
        val testObserver = givenInteractor().ratesStream.test()

        scheduler.triggerActions()
        scheduler.advanceTimeBy(2, TimeUnit.SECONDS)

        testObserver.assertValueSequence(
            listOf(
                RatesEvent.Value(expectedInitialEurRates),
                RatesEvent.Value(expectedInitialEurRates),
                RatesEvent.Value(expectedInitialEurRates)
            )
        )
    }

    @Test
    fun `return rates for eur multiplied`() {
        val interactor = givenInteractor()
        val testObserver = interactor.ratesStream.test()
        scheduler.triggerActions()

        interactor.applyMultiplier(100.toBigDecimal())

        testObserver.assertValueSequence(
            listOf(
                RatesEvent.Value(expectedInitialEurRates),
                RatesEvent.Value(expectedInitialEurRatesMultiplied)
            )
        )
    }

    @Test
    fun `return rates with new base multiplied by value from new base rate`() {
        val interactor = givenInteractor()
        val testObserver = interactor.ratesStream.test()
        scheduler.triggerActions()

        interactor.applyMultiplier(100.toBigDecimal())
        scheduler.triggerActions()
        interactor.changeBase(
            Rate(
                "PLN",
                435.toBigDecimal().stripTrailingZeros(),
                RateResource.PLN
            )
        )
        scheduler.triggerActions()

        testObserver.assertValueSequence(
            listOf(
                RatesEvent.Value(expectedInitialEurRates),
                RatesEvent.Value(expectedInitialEurRatesMultiplied),
                RatesEvent.Value(
                    Rates(
                        base = Rate(
                            "PLN",
                            435.toBigDecimal().stripTrailingZeros(),
                            RateResource.PLN
                        ),
                        ratesMap = linkedMapOf(
                            "EUR" to 435.toBigDecimal().multiply(0.27.toBigDecimal())
                                .stripTrailingZeros(),
                            "CHF" to 435.toBigDecimal().multiply(0.24.toBigDecimal())
                                .stripTrailingZeros()
                        )
                    )
                )
            )
        )
    }

    @Test
    fun `replay last rates to new observer`() {
        val interactor = givenInteractor()
        val testObserver = interactor.ratesStream.test()
        scheduler.advanceTimeBy(1, TimeUnit.SECONDS)
        scheduler.triggerActions()
        interactor.applyMultiplier(100.toBigDecimal())
        scheduler.triggerActions()

        val testObserver2 = interactor.ratesStream.test()

        testObserver.assertValueSequence(
            listOf(
                RatesEvent.Value(expectedInitialEurRates),
                RatesEvent.Value(expectedInitialEurRates),
                RatesEvent.Value(expectedInitialEurRatesMultiplied)
            )
        )
        testObserver2.assertValue(RatesEvent.Value(expectedInitialEurRatesMultiplied))
    }

    private companion object {

        val eurRatesResponse = RatesResponse(
            base = "EUR",
            rates = linkedMapOf(
                "PLN" to "4.35",
                "CHF" to "1.15"
            )
        )
        val plnRatesResponse = RatesResponse(
            base = "PLN",
            rates = linkedMapOf(
                "EUR" to "0.27",
                "CHF" to "0.24"
            )
        )
        val expectedInitialEurRates = Rates(
            base = Rate("EUR", BigDecimal.ONE, RateResource.EUR),
            ratesMap = linkedMapOf(
                "PLN" to 4.35.toBigDecimal(),
                "CHF" to 1.15.toBigDecimal()
            )
        )
        val expectedInitialEurRatesMultiplied = Rates(
            base = Rate("EUR", BigDecimal.ONE, RateResource.EUR),
            ratesMap = linkedMapOf(
                "PLN" to 435.toBigDecimal().stripTrailingZeros(),
                "CHF" to 115.toBigDecimal().stripTrailingZeros()
            )
        )
    }

    private fun givenInteractor() = RatesInteractor(gateway)
}