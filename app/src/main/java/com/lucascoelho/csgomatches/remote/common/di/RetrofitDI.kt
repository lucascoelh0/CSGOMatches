package com.lucascoelho.csgomatches.remote.common.di

import com.google.gson.GsonBuilder
import com.lucascoelho.csgomatches.remote.common.provider.IOkHttpClientProvider
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import org.koin.dsl.module
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitDI {
    val module = module {
        factory {
            val httpLoggingInterceptorLevel = if (BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BASIC
            else
                HttpLoggingInterceptor.Level.NONE

            HttpLoggingInterceptor().apply {
                level = httpLoggingInterceptorLevel
            }
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
//         Base URL
//        factory<Retrofit> {
//            get<Builder>()
//                    .baseUrl("https://url.com")
//                    .build()
//        }
    }
}
