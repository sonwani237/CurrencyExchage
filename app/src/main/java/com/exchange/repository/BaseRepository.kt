package com.exchange.repository

import android.app.Application
import com.exchange.webService.ApiClient
import com.exchange.webService.ApiInterface

open class BaseRepository(application: Application) {


    val apiInterface : ApiInterface by lazy {
        ApiClient.getApiClient()
    }


}