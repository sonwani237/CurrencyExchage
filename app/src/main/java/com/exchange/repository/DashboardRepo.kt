package com.exchange.repository

import android.app.Application
import com.exchange.model.CurrencyExchange
import retrofit2.Response

class DashboardRepo(application: Application) : BaseRepository(application) {

    suspend fun fetchBets(): Response<CurrencyExchange> {
        return apiInterface.fetchExchangeRate()
    }

}