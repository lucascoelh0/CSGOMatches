package com.lucascoelho.csgomatches.datasource.common.di

import com.lucascoelho.csgomatches.datasource.common.provider.IOkHttpClientProvider
import com.lucascoelho.csgomatches.datasource.common.provider.OkHttpClientProvider
import com.lucascoelho.csgomatches.datasource.common.remote.TokenQueryInterceptor
import okhttp3.Interceptor
import org.koin.core.scope.Scope
import org.koin.dsl.module

object OkHttpClientDI {
    val module = module {
        factory<IOkHttpClientProvider> {
            OkHttpClientProvider(
                okHttpClientBuilderProvider = get(),
                interceptors = getInterceptors()
            )
        }
    }

    private fun Scope.getInterceptors(): List<Interceptor> {
        return mutableListOf<Interceptor>(
            get<TokenQueryInterceptor>()
        )
    }
}
