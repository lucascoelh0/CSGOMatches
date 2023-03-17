package com.lucascoelho.csgomatches.remote.common.di

import com.lucascoelho.csgomatches.remote.common.provider.IOkHttpClientProvider
import com.lucascoelho.csgomatches.remote.common.provider.OkHttpClientProvider
import org.koin.dsl.module

object OkHttpClientDI {
    val module = module {
        factory<IOkHttpClientProvider> {
            OkHttpClientProvider(okHttpClientBuilderProvider = get())
        }
    }

}
