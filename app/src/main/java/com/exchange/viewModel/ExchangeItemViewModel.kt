package com.exchange.viewModel

import androidx.databinding.BaseObservable
import com.exchange.model.ExchangeRete

class ExchangeItemViewModel(model: ExchangeRete) : BaseObservable(){

    private var mModel: ExchangeRete? =null

    init {
        this.mModel = model
    }

    fun setData(exchangeRete: ExchangeRete) {
        mModel = exchangeRete
        notifyChange()
    }

    fun getCurrency() : String{
        return mModel?.currency?:"N/A"
    }

    fun getRate() : String{
        return mModel?.exchangeVal?.toString()?:"N/A"
    }


}