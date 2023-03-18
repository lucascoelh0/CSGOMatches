package com.lucascoelho.csgomatches.datasource.common.di

import com.lucascoelho.csgomatches.datasource.common.provider.IOkHttpClientProvider
import com.lucascoelho.csgomatches.datasource.common.provider.OkHttpClientProvider
import org.koin.dsl.module

object OkHttpClientDI {
    val module = module {
        factory<IOkHttpClientProvider> {
            OkHttpClientProvider(okHttpClientBuilderProvider = get())
        }
    }

}