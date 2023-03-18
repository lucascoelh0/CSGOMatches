package com.lucascoelho.csgomatches.datasource.common.di

object DataSourceDI {
    val module = RemoteDI.module +
            RetrofitDI.module +
            OkHttpClientDI.module
}
