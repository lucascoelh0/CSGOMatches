package com.lucascoelho.csgomatches.datasource.common.provider

import okhttp3.OkHttpClient

interface IOkHttpClientProvider {
    fun getOkHttpClient(): OkHttpClient
}
