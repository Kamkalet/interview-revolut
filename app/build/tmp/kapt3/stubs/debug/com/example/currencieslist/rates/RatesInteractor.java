package com.example.currencieslist.rates;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bJ\u000e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0007J<\u0010\u0016\u001a\u00020\u000e2\"\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190\u0018j\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019`\u001a2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u000bH\u0002JH\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0012\f\u0012\n \b*\u0004\u0018\u00010\u000b0\u000b0\u001d2\"\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190\u0018j\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019`\u001a2\u0006\u0010\u0013\u001a\u00020\u000bH\u0002R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u000b0\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001e"}, d2 = {"Lcom/example/currencieslist/rates/RatesInteractor;", "", "gateway", "Lcom/example/currencieslist/rates/network/RatesGateway;", "(Lcom/example/currencieslist/rates/network/RatesGateway;)V", "baseSubject", "Lio/reactivex/subjects/BehaviorSubject;", "Lcom/example/currencieslist/rates/Rate;", "kotlin.jvm.PlatformType", "multiplierSubject", "Lio/reactivex/subjects/PublishSubject;", "Ljava/math/BigDecimal;", "ratesStream", "Lio/reactivex/Observable;", "Lcom/example/currencieslist/rates/RatesEvent;", "getRatesStream", "()Lio/reactivex/Observable;", "applyMultiplier", "", "multiplier", "changeBase", "newBase", "mapToModel", "rates", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "base", "multiplyWithUserInput", "", "app_debug"})
@com.example.currencieslist.di.ApplicationScope()
public final class RatesInteractor {
    private io.reactivex.subjects.BehaviorSubject<com.example.currencieslist.rates.Rate> baseSubject;
    private final io.reactivex.subjects.PublishSubject<java.math.BigDecimal> multiplierSubject = null;
    @org.jetbrains.annotations.NotNull()
    private final io.reactivex.Observable<com.example.currencieslist.rates.RatesEvent> ratesStream = null;
    private final com.example.currencieslist.rates.network.RatesGateway gateway = null;
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Observable<com.example.currencieslist.rates.RatesEvent> getRatesStream() {
        return null;
    }
    
    public final void changeBase(@org.jetbrains.annotations.NotNull()
    com.example.currencieslist.rates.Rate newBase) {
    }
    
    public final void applyMultiplier(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal multiplier) {
    }
    
    private final com.example.currencieslist.rates.RatesEvent mapToModel(java.util.LinkedHashMap<java.lang.String, java.lang.String> rates, com.example.currencieslist.rates.Rate base, java.math.BigDecimal multiplier) {
        return null;
    }
    
    private final java.util.Map<java.lang.String, java.math.BigDecimal> multiplyWithUserInput(java.util.LinkedHashMap<java.lang.String, java.lang.String> rates, java.math.BigDecimal multiplier) {
        return null;
    }
    
    @javax.inject.Inject()
    public RatesInteractor(@org.jetbrains.annotations.NotNull()
    com.example.currencieslist.rates.network.RatesGateway gateway) {
        super();
    }
}