package me.aprilian.coinbasesample.repository

import me.aprilian.coinbasesample.api.CoinApiService
import me.aprilian.coinbasesample.data.LatestCoinResponse
import retrofit2.Response
import javax.inject.Inject

//currently is not used
class ApiHelperImpl @Inject constructor(
    private val coinApiService: CoinApiService
): ApiHelper{
    override suspend fun getLatestCoin(start:Int, limit: Int, convert: String): Response<LatestCoinResponse> {
        return coinApiService.getLatestCoin(start, limit, convert)
    }
}