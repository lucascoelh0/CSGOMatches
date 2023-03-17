package com.lucascoelho.csgomatches.remote.common.provider

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

class OkHttpClientProvider(
    private val okHttpClientBuilderProvider: IOkHttpClientBuilderProvider
) : IOkHttpClientProvider {
    override fun getOkHttpClient(): OkHttpClient =
        okHttpClientBuilderProvider.getOkHttpClientBuilder().apply {
            readTimeout(60, TimeUnit.SECONDS)
            writeTimeout(60, TimeUnit.SECONDS)
        }.build()
}
