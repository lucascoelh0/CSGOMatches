package com.lucascoelho.csgomatches.datasource.common.di

import com.lucascoelho.csgomatches.datasource.matches.client.MatchesClient
import com.lucascoelho.csgomatches.datasource.matches.datasource.IMatchesDataSource
import com.lucascoelho.csgomatches.datasource.matches.datasource.MatchesDataSource
import com.lucascoelho.csgomatches.datasource.matches.repository.IMatchesRepository
import com.lucascoelho.csgomatches.datasource.matches.repository.MatchesRepository
import org.koin.dsl.module

object RepositoryDI {
    val module = module {
        single<IMatchesDataSource> {
            MatchesDataSource(
                client = get() as MatchesClient
            )
        }

        single<IMatchesRepository> {
            MatchesRepository(
                matchesDataSource = get() as IMatchesDataSource
            )
        }
    }
}
