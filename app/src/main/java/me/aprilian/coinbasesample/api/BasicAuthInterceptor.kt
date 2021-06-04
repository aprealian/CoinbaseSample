package me.aprilian.coinbasesample.api

import me.aprilian.coinbasesample.utils.Constants
import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import kotlin.jvm.Throws

class BasicAuthInterceptor(user: String = "", password: String = "") : Interceptor {
    //Note: if you want to use user password for API Authentication
    private val credentials: String = Credentials.basic(user, password)

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val authenticatedRequest = request.newBuilder()
            //.header("Authorization", credentials).build()
            .header("X-CMC_PRO_API_KEY", Constants.COINMARKETCAP_AUTH_TOKEN).build() //CoinMarketCap Auth
        return chain.proceed(authenticatedRequest)
    }
}
