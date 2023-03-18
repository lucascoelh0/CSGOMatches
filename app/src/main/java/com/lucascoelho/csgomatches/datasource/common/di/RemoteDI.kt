package com.lucascoelho.csgomatches.datasource.common.di

import com.lucascoelho.csgomatches.datasource.matches.client.MatchesClient
import org.koin.dsl.module
import retrofit2.Retrofit

object RemoteDI {
    val module = module {
        factory<MatchesClient> {
            get<Retrofit>().create(MatchesClient::class.java)
        }
    }
}
