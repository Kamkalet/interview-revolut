package com.example.currencieslist

import android.app.Application
import com.example.currencieslist.di.AppComponent
import com.example.currencieslist.di.AppModule
import com.example.currencieslist.di.DaggerAppComponent


class App : Application() {

    var component: AppComponent? = null

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}