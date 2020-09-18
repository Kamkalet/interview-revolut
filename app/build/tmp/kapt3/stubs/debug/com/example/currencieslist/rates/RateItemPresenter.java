package com.example.currencieslist.rates;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\rH\u0002J\u001e\u0010\u000e\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\fJ\u000e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/example/currencieslist/rates/RateItemPresenter;", "", "interactor", "Lcom/example/currencieslist/rates/RatesInteractor;", "(Lcom/example/currencieslist/rates/RatesInteractor;)V", "disposable", "Lio/reactivex/disposables/Disposable;", "rate", "Lcom/example/currencieslist/rates/Rate;", "view", "Lcom/example/currencieslist/rates/RateItemView;", "formatAndSetRateText", "", "Ljava/math/BigDecimal;", "onBind", "adapterPosition", "", "onRateGainedFocus", "onRateInputChanged", "newInput", "", "onUnbind", "app_debug"})
public final class RateItemPresenter {
    private com.example.currencieslist.rates.RateItemView view;
    private io.reactivex.disposables.Disposable disposable;
    private com.example.currencieslist.rates.Rate rate;
    private final com.example.currencieslist.rates.RatesInteractor interactor = null;
    
    public final void onBind(@org.jetbrains.annotations.NotNull()
    com.example.currencieslist.rates.RateItemView view, @org.jetbrains.annotations.NotNull()
    com.example.currencieslist.rates.Rate rate, int adapterPosition) {
    }
    
    private final void formatAndSetRateText(java.math.BigDecimal rate) {
    }
    
    public final void onRateInputChanged(@org.jetbrains.annotations.NotNull()
    java.lang.String newInput) {
    }
    
    public final void onRateGainedFocus() {
    }
    
    public final void onUnbind() {
    }
    
    @javax.inject.Inject()
    public RateItemPresenter(@org.jetbrains.annotations.NotNull()
    com.example.currencieslist.rates.RatesInteractor interactor) {
        super();
    }
}