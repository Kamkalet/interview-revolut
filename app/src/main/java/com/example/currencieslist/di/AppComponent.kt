package com.example.currencieslist.di

import com.example.currencieslist.rates.RatesActivity
import com.example.currencieslist.rates.di.RatesModule
import dagger.Component
import javax.inject.Scope


@ApplicationScope
@Component(modules = [(AppModule::class), (RatesModule::class)])
interface AppComponent {
    fun inject(target: RatesActivity)
}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationScope