package com.lucascoelho.csgomatches.datasource.common.di

import com.google.gson.GsonBuilder
import com.lucascoelho.csgomatches.datasource.common.provider.IOkHttpClientBuilderProvider
import com.lucascoelho.csgomatches.datasource.common.provider.IOkHttpClientProvider
import com.lucascoelho.csgomatches.datasource.common.provider.OkHttpClientBuilderProvider
import com.lucascoelho.csgomatches.datasource.common.remote.TokenQueryInterceptor
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitDI {
    val module = module {
        single { TokenQueryInterceptor() }
        factory {
            val httpLoggingInterceptorLevel = if (BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BASIC
            else
                HttpLoggingInterceptor.Level.NONE

            HttpLoggingInterceptor().apply {
                level = httpLoggingInterceptorLevel
            }
        }
        factory<IOkHttpClientBuilderProvider> {
            OkHttpClientBuilderProvider()
        }
        factory {
            val okHttpClientProvider = get<IOkHttpClientProvider>()
            okHttpClientProvider.getOkHttpClient()
        }
        factory<Builder> {
            Builder()
                .client(get())
                .addConverterFactory(
                    GsonConverterFactory.create(
                        GsonBuilder().setLenient().create()
                    )
                )
        }
        factory<Retrofit> {
            get<Builder>()
                .baseUrl("https://api.pandascore.co")
                .build()
        }
    }
}
