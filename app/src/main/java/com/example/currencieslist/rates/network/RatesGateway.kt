package com.example.currencieslist.rates.network

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RatesGateway {

    @GET("latest")
    fun getCurrencies(@Query("base") base: String): Single<RatesResponse>
}

data class RatesResponse(
    val base: String,
    val rates: LinkedHashMap<String, String>
)