package com.lucascoelho.baseproject.datasource.common.di

import com.lucascoelho.baseproject.datasource.common.provider.IOkHttpClientProvider
import com.lucascoelho.baseproject.datasource.common.provider.OkHttpClientProvider
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
//                get<ExampleInterceptor>()
        )
    }
}
