package com.example.currencieslist.rates;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010\b\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\r"}, d2 = {"Lcom/example/currencieslist/rates/RatesView;", "", "initRatesList", "", "setErrorVisibility", "visible", "", "setProgressVisibility", "setRatesItemList", "rates", "", "Lcom/example/currencieslist/rates/Rate;", "setRatesVisibility", "app_debug"})
public abstract interface RatesView {
    
    public abstract void setRatesItemList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.currencieslist.rates.Rate> rates);
    
    public abstract void initRatesList();
    
    public abstract void setErrorVisibility(boolean visible);
    
    public abstract void setProgressVisibility(boolean visible);
    
    public abstract void setRatesVisibility(boolean visible);
}