package me.aprilian.coinbasesample.utils

import me.aprilian.coinbasesample.BuildConfig

object Constants {
    val BASE_URL =  if (BuildConfig.DEBUG) "https://sandbox-api.coinmarketcap.com" else "https://pro-api.coinmarketcap.com"
    val COINMARKETCAP_AUTH_TOKEN = if (BuildConfig.DEBUG) "b54bcf4d-1bca-4e8e-9a24-22ff2c3d462c" else "8b876e81-d3d2-4289-8b00-6c290b856ab2"
}