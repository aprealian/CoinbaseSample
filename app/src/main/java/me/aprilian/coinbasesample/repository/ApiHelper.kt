package me.aprilian.coinbasesample.repository

import me.aprilian.coinbasesample.data.LatestCoinResponse
import retrofit2.Response

interface ApiHelper {
    suspend fun getLatestCoin(start:Int, limit: Int, convert: String): Response<LatestCoinResponse>
}