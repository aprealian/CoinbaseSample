package me.aprilian.coinbasesample.data
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LatestCoinResponse(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("status")
    val status: Status
): Parcelable {
    @Parcelize
    data class Data(
        @SerializedName("circulating_supply")
        val circulatingSupply: Int?,
        @SerializedName("cmc_rank")
        val cmcRank: Int?,
        @SerializedName("date_added")
        val dateAdded: String?,
        @SerializedName("id")
        val id: Int,
        @SerializedName("last_updated")
        val lastUpdated: String?,
        @SerializedName("max_supply")
        val maxSupply: Int?,
        @SerializedName("name")
        val name: String = "",
        @SerializedName("num_market_pairs")
        val numMarketPairs: Int?,
        @SerializedName("quote")
        val quote: Quote?,
        @SerializedName("slug")
        val slug: String?,
        @SerializedName("symbol")
        val symbol: String = "",
        @SerializedName("tags")
        val tags: List<String>?,
        @SerializedName("total_supply")
        val totalSupply: Int?
    ): Parcelable {
        @Parcelize
        data class Quote(
            @SerializedName("BTC")
            val bTC: BTC?,
            @SerializedName("ETH")
            val eTH: ETH?,
            @SerializedName("USD")
            val uSD: USD?
        ): Parcelable {
            @Parcelize
            data class BTC(
                @SerializedName("last_updated")
                val lastUpdated: String?,
                @SerializedName("market_cap")
                val marketCap: Int?,
                @SerializedName("percent_change_1h")
                val percentChange1h: Int?,
                @SerializedName("percent_change_24h")
                val percentChange24h: Int?,
                @SerializedName("percent_change_7d")
                val percentChange7d: Int?,
                @SerializedName("price")
                val price: Int?,
                @SerializedName("volume_24h")
                val volume24h: Int?
            ): Parcelable

            @Parcelize
            data class ETH(
                @SerializedName("last_updated")
                val lastUpdated: String?,
                @SerializedName("market_cap")
                val marketCap: Int?,
                @SerializedName("percent_change_1h")
                val percentChange1h: Int?,
                @SerializedName("percent_change_24h")
                val percentChange24h: Int?,
                @SerializedName("percent_change_7d")
                val percentChange7d: Int?,
                @SerializedName("price")
                val price: Int?,
                @SerializedName("volume_24h")
                val volume24h: Int?
            ): Parcelable

            @Parcelize
            data class USD(
                @SerializedName("last_updated")
                val lastUpdated: String?,
                @SerializedName("market_cap")
                val marketCap: Long?,
                @SerializedName("percent_change_1h")
                val percentChange1h: Double?,
                @SerializedName("percent_change_24h")
                val percentChange24h: Double?,
                @SerializedName("percent_change_7d")
                val percentChange7d: Double?,
                @SerializedName("price")
                val price: Double?,
                @SerializedName("volume_24h")
                val volume24h: Long?
            ): Parcelable
        }
    }

    @Parcelize
    data class Status(
        @SerializedName("credit_count")
        val creditCount: Int?,
        @SerializedName("elapsed")
        val elapsed: Int?,
        @SerializedName("error_code")
        val errorCode: Int?,
        @SerializedName("error_message")
        val errorMessage: String?,
        @SerializedName("timestamp")
        val timestamp: String?
    ): Parcelable
}