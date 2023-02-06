package com.lucascoelho.baseproject.datasource.common.di

object DatasourceDI {
    val module = RetrofitDI.module +
            OkHttpClientDI.module +
            DatabaseDI.module
}
