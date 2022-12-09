package com.exchange.webService

import com.exchange.constant.ApiConstant
import com.exchange.model.CurrencyExchange
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET(ApiConstant.EXCHANGE_RATE)
    suspend fun fetchExchangeRate(): Response<CurrencyExchange>

}