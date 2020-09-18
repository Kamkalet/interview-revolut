package com.example.currencieslist.rates

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.disposables.Disposables
import java.math.BigDecimal
import javax.inject.Inject


class RateItemPresenter @Inject constructor(private val interactor: RatesInteractor) {

    private var view: RateItemView? = null
    private var disposable: Disposable = Disposables.disposed()
    private lateinit var rate: Rate

    fun onBind(
        view: RateItemView,
        rate: Rate,
        adapterPosition: Int
    ) {
        this.view = view
        this.rate = rate
        view.apply {
            setFlag(rate.resource.imageSrc)
            setCurrencyCode(rate.code)
            setRateDescription(rate.resource.description)
            formatAndSetRateText(rate.value)

            disposable =
                interactor.ratesStream
                    .filter { it is RatesEvent.Value && it.rates.base.code != rate.code }
                    .map { (it as RatesEvent.Value).rates.ratesMap[rate.code]!! }
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        rate.value = it
                        formatAndSetRateText(rate.value)
                    }

            if (adapterPosition > 0) {
                initOnEditTextClickListener()
            } else {
                initTextWatcher()
            }
        }
    }

    private fun formatAndSetRateText(rate: BigDecimal) {
        if (rate.compareTo(BigDecimal.ZERO) == 0) {
            view?.setRateText("")
        } else {
            view?.setRateText(rate.toPlainString())
        }
    }

    fun onRateInputChanged(newInput: String) {
        if (newInput.isBlank()) {
            interactor.applyMultiplier(BigDecimal.ZERO)
            rate.value = BigDecimal.ZERO
        } else {
            newInput.toBigDecimalOrNull()?.let {
                interactor.applyMultiplier(it)
                rate.value = it
            }
        }
    }

    fun onRateGainedFocus() {
        interactor.changeBase(rate)
    }

    fun onUnbind() {
        disposable.dispose()
        disposable = Disposables.disposed()
    }
}

interface RateItemView {

    fun setRateText(rate: String)
    fun initTextWatcher()
    fun setFlag(@DrawableRes img: Int)
    fun setRateDescription(@StringRes description: Int)
    fun initOnEditTextClickListener()
    fun setCurrencyCode(code: String)
}