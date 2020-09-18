package com.example.currencieslist.rates;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0011H\u0014J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0016\u0010\u001a\u001a\u00020\u00112\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0016J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001f"}, d2 = {"Lcom/example/currencieslist/rates/RatesActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/example/currencieslist/rates/RatesView;", "()V", "presenter", "Lcom/example/currencieslist/rates/RatesPresenter;", "getPresenter", "()Lcom/example/currencieslist/rates/RatesPresenter;", "setPresenter", "(Lcom/example/currencieslist/rates/RatesPresenter;)V", "ratesAdapter", "Lcom/example/currencieslist/rates/RatesAdapter;", "getRatesAdapter", "()Lcom/example/currencieslist/rates/RatesAdapter;", "setRatesAdapter", "(Lcom/example/currencieslist/rates/RatesAdapter;)V", "initRatesList", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setErrorVisibility", "visible", "", "setProgressVisibility", "setRatesItemList", "rates", "", "Lcom/example/currencieslist/rates/Rate;", "setRatesVisibility", "app_debug"})
public final class RatesActivity extends androidx.appcompat.app.AppCompatActivity implements com.example.currencieslist.rates.RatesView {
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public com.example.currencieslist.rates.RatesPresenter presenter;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public com.example.currencieslist.rates.RatesAdapter ratesAdapter;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.currencieslist.rates.RatesPresenter getPresenter() {
        return null;
    }
    
    public final void setPresenter(@org.jetbrains.annotations.NotNull()
    com.example.currencieslist.rates.RatesPresenter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.currencieslist.rates.RatesAdapter getRatesAdapter() {
        return null;
    }
    
    public final void setRatesAdapter(@org.jetbrains.annotations.NotNull()
    com.example.currencieslist.rates.RatesAdapter p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void initRatesList() {
    }
    
    @java.lang.Override()
    public void setErrorVisibility(boolean visible) {
    }
    
    @java.lang.Override()
    public void setProgressVisibility(boolean visible) {
    }
    
    @java.lang.Override()
    public void setRatesVisibility(boolean visible) {
    }
    
    @java.lang.Override()
    public void setRatesItemList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.currencieslist.rates.Rate> rates) {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    public RatesActivity() {
        super();
    }
}