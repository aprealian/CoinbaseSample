package me.aprilian.coinbasesample.api

import me.aprilian.coinbasesample.data.LatestCoinResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinApiService {
    @GET("/v1/cryptocurrency/listings/latest")
    suspend fun getLatestCoin(
        @Query("start") start: Int = 1,
        @Query("limit") limit: Int = 10,
        @Query("convert") convert: String = "USD"
    ): Response<LatestCoinResponse>
}