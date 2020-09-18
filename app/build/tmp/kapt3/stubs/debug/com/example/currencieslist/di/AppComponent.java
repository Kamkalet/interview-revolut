package com.example.currencieslist.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/currencieslist/di/AppComponent;", "", "inject", "", "target", "Lcom/example/currencieslist/rates/RatesActivity;", "app_debug"})
@dagger.Component(modules = {com.example.currencieslist.di.AppModule.class, com.example.currencieslist.rates.di.RatesModule.class})
@ApplicationScope()
public abstract interface AppComponent {
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    com.example.currencieslist.rates.RatesActivity target);
}