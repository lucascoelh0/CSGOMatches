package com.lucascoelho.csgomatches.datasource.common.provider

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

class OkHttpClientProvider(
    private val okHttpClientBuilderProvider: IOkHttpClientBuilderProvider,
    private val interceptors: List<Interceptor>
) : IOkHttpClientProvider {
    override fun getOkHttpClient(): OkHttpClient =
        okHttpClientBuilderProvider.getOkHttpClientBuilder().apply {
            interceptors.forEach { interceptor ->
                addInterceptor(interceptor)
            }
            readTimeout(60, TimeUnit.SECONDS)
            writeTimeout(60, TimeUnit.SECONDS)
        }.build()
}
