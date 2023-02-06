package com.lucascoelho.baseproject.datasource.common.provider

import okhttp3.OkHttpClient

interface IOkHttpClientBuilderProvider {
    fun getOkHttpClientBuilder(): OkHttpClient.Builder
}
