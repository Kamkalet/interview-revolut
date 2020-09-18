package com.example.currencieslist.rates;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0015\b\u0007\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\u0014\u0010\u0014\u001a\u00020\r2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/example/currencieslist/rates/RatesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/currencieslist/rates/RatesAdapter$RateViewHolder;", "rateItemItemPresenterProvider", "Ljavax/inject/Provider;", "Lcom/example/currencieslist/rates/RateItemPresenter;", "(Ljavax/inject/Provider;)V", "list", "", "Lcom/example/currencieslist/rates/Rate;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setItems", "model", "", "RateViewHolder", "app_debug"})
public final class RatesAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.currencieslist.rates.RatesAdapter.RateViewHolder> {
    private java.util.List<com.example.currencieslist.rates.Rate> list;
    private final javax.inject.Provider<com.example.currencieslist.rates.RateItemPresenter> rateItemItemPresenterProvider = null;
    
    public final void setItems(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.currencieslist.rates.Rate> model) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.currencieslist.rates.RatesAdapter.RateViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.currencieslist.rates.RatesAdapter.RateViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @javax.inject.Inject()
    public RatesAdapter(@org.jetbrains.annotations.NotNull()
    javax.inject.Provider<com.example.currencieslist.rates.RateItemPresenter> rateItemItemPresenterProvider) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u001c\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\b\u0010\u0018\u001a\u00020\fH\u0016J\b\u0010\u0019\u001a\u00020\fH\u0016J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0012\u0010 \u001a\u00020\f2\b\b\u0001\u0010!\u001a\u00020\u001fH\u0016J\u0010\u0010\"\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u001cH\u0016J\u0006\u0010#\u001a\u00020\fR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/example/currencieslist/rates/RatesAdapter$RateViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/example/currencieslist/rates/RateItemView;", "view", "Landroid/view/View;", "presenter", "Lcom/example/currencieslist/rates/RateItemPresenter;", "(Landroid/view/View;Lcom/example/currencieslist/rates/RateItemPresenter;)V", "flag", "Landroid/widget/ImageView;", "onEditTextClickedCallback", "Lkotlin/Function0;", "", "rateCodeTextView", "Landroid/widget/TextView;", "rateDescription", "textWatcher", "Landroid/text/TextWatcher;", "valueEditText", "Landroid/widget/EditText;", "bind", "rate", "Lcom/example/currencieslist/rates/Rate;", "callback", "initOnEditTextClickListener", "initTextWatcher", "setCurrencyCode", "code", "", "setFlag", "img", "", "setRateDescription", "description", "setRateText", "unbind", "app_debug"})
    public static final class RateViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder implements com.example.currencieslist.rates.RateItemView {
        private final android.widget.ImageView flag = null;
        private final android.widget.TextView rateCodeTextView = null;
        private final android.widget.TextView rateDescription = null;
        private final android.widget.EditText valueEditText = null;
        private kotlin.jvm.functions.Function0<kotlin.Unit> onEditTextClickedCallback;
        private final android.text.TextWatcher textWatcher = null;
        private final com.example.currencieslist.rates.RateItemPresenter presenter = null;
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.example.currencieslist.rates.Rate rate, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
        }
        
        @java.lang.Override()
        public void initOnEditTextClickListener() {
        }
        
        @java.lang.Override()
        public void initTextWatcher() {
        }
        
        @java.lang.Override()
        public void setCurrencyCode(@org.jetbrains.annotations.NotNull()
        java.lang.String code) {
        }
        
        @java.lang.Override()
        public void setFlag(int img) {
        }
        
        @java.lang.Override()
        public void setRateDescription(@androidx.annotation.StringRes()
        int description) {
        }
        
        @java.lang.Override()
        public void setRateText(@org.jetbrains.annotations.NotNull()
        java.lang.String rate) {
        }
        
        public final void unbind() {
        }
        
        public RateViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view, @org.jetbrains.annotations.NotNull()
        com.example.currencieslist.rates.RateItemPresenter presenter) {
            super(null);
        }
    }
}