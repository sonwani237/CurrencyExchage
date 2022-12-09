package com.exchange.model

import com.google.gson.JsonElement
import org.json.JSONObject

data class CurrencyExchange (val date: String, val aud: JsonElement) {
}