package me.aprilian.coinbasesample.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Coin(
    val id: Long,
    val name: String,
    val symbol: String,
    val price: Long,
    val growth: Double
) : Parcelable {
    companion object {
        suspend fun getSample(): ArrayList<Coin>{
            return arrayListOf(
                Coin(1, "Bitcoin", "BTC", 3000000, 2.67),
                Coin(2, "DogeCoin", "DOGE", 30, 20.00),
                Coin(3, "TRON", "TRX", 78, 20.00),
                Coin(4, "Bitcoin", "BTC", 3000000, 2.67),
                Coin(5, "DogeCoin", "DOGE", 30, 20.00),
                Coin(6, "TRON", "TRX", 78, 20.00),
            )
        }
    }
}