package com.example.currencieslist.rates;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\nJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/example/currencieslist/rates/RatesPresenter;", "", "interactor", "Lcom/example/currencieslist/rates/RatesInteractor;", "imageResolver", "Lcom/example/currencieslist/rates/ImageResolver;", "(Lcom/example/currencieslist/rates/RatesInteractor;Lcom/example/currencieslist/rates/ImageResolver;)V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "attach", "", "view", "Lcom/example/currencieslist/rates/RatesView;", "detach", "toRatesModelList", "", "Lcom/example/currencieslist/rates/Rate;", "ratesEvent", "Lcom/example/currencieslist/rates/RatesEvent;", "app_debug"})
public final class RatesPresenter {
    private io.reactivex.disposables.CompositeDisposable disposables;
    private final com.example.currencieslist.rates.RatesInteractor interactor = null;
    private final com.example.currencieslist.rates.ImageResolver imageResolver = null;
    
    public final void attach(@org.jetbrains.annotations.NotNull()
    com.example.currencieslist.rates.RatesView view) {
    }
    
    private final java.util.List<com.example.currencieslist.rates.Rate> toRatesModelList(com.example.currencieslist.rates.RatesEvent ratesEvent) {
        return null;
    }
    
    public final void detach() {
    }
    
    @javax.inject.Inject()
    public RatesPresenter(@org.jetbrains.annotations.NotNull()
    com.example.currencieslist.rates.RatesInteractor interactor, @org.jetbrains.annotations.NotNull()
    com.example.currencieslist.rates.ImageResolver imageResolver) {
        super();
    }
}