package com.example.currencieslist.rates.network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'\u00a8\u0006\u0007"}, d2 = {"Lcom/example/currencieslist/rates/network/RatesGateway;", "", "getCurrencies", "Lio/reactivex/Single;", "Lcom/example/currencieslist/rates/network/RatesResponse;", "base", "", "app_debug"})
public abstract interface RatesGateway {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "latest")
    public abstract io.reactivex.Single<com.example.currencieslist.rates.network.RatesResponse> getCurrencies(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "base")
    java.lang.String base);
}