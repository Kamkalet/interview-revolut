package com.example.currencieslist.rates.di

import com.example.currencieslist.di.ApplicationScope
import com.example.currencieslist.rates.network.RatesGateway
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private const val ENDPOINT = "https://hiring.revolut.codes/api/android/"

@Module
class RatesModule {

    @Provides
    @ApplicationScope
    fun provideTestApi(): RatesGateway {
        val retrofit = Retrofit.Builder()
            .baseUrl(ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        return retrofit.create(RatesGateway::class.java)
    }
}