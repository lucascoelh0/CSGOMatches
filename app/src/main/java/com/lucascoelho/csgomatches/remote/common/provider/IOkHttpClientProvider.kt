package com.lucascoelho.csgomatches.remote.common.provider

import okhttp3.OkHttpClient

interface IOkHttpClientProvider {
    fun getOkHttpClient(): OkHttpClient
}
