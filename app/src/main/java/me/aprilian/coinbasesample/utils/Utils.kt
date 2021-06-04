package me.aprilian.coinbasesample.utils

import android.content.Context
import android.widget.Toast

fun Context.toast(message: String?, duration: Int = Toast.LENGTH_SHORT){
    message?.let {
        Toast.makeText(this, message, duration).show()
    }
}