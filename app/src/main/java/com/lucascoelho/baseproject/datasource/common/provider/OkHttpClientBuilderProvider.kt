package com.lucascoelho.baseproject.datasource.common.provider

import okhttp3.OkHttpClient

class OkHttpClientBuilderProvider : IOkHttpClientBuilderProvider {
    override fun getOkHttpClientBuilder(): OkHttpClient.Builder = OkHttpClient.Builder()
}
