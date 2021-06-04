package me.aprilian.coinbasesample.repository

import javax.inject.Inject

class CoinRepository @Inject constructor(
    private val apiHelper: ApiHelper
){
    suspend fun getLatestCoin(start:Int = 1, limit: Int = 10, convert: String = "USD") = apiHelper.getLatestCoin(start, limit, convert)
}