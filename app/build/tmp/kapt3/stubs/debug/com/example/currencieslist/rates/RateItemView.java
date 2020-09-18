package com.example.currencieslist.rates;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u00020\u00032\b\b\u0001\u0010\t\u001a\u00020\nH&J\u0012\u0010\u000b\u001a\u00020\u00032\b\b\u0001\u0010\f\u001a\u00020\nH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0007H&\u00a8\u0006\u000f"}, d2 = {"Lcom/example/currencieslist/rates/RateItemView;", "", "initOnEditTextClickListener", "", "initTextWatcher", "setCurrencyCode", "code", "", "setFlag", "img", "", "setRateDescription", "description", "setRateText", "rate", "app_debug"})
public abstract interface RateItemView {
    
    public abstract void setRateText(@org.jetbrains.annotations.NotNull()
    java.lang.String rate);
    
    public abstract void initTextWatcher();
    
    public abstract void setFlag(@androidx.annotation.DrawableRes()
    int img);
    
    public abstract void setRateDescription(@androidx.annotation.StringRes()
    int description);
    
    public abstract void initOnEditTextClickListener();
    
    public abstract void setCurrencyCode(@org.jetbrains.annotations.NotNull()
    java.lang.String code);
}