package com.lucascoelho.csgomatches.datasource.common.di

object DataSourceDI {
    val module = RepositoryDI.module +
            RemoteDI.module +
            RetrofitDI.module +
            OkHttpClientDI.module
}
