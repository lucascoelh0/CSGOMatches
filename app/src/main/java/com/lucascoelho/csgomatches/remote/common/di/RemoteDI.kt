package com.lucascoelho.csgomatches.remote.common.di

object RemoteDI {
    val module = RetrofitDI.module +
            OkHttpClientDI.module
}
