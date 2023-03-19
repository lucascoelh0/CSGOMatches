package com.lucascoelho.csgomatches.datasource.common.di

import com.lucascoelho.csgomatches.datasource.matches.client.MatchesClient
import com.lucascoelho.csgomatches.datasource.matches.datasource.IMatchesDataSource
import com.lucascoelho.csgomatches.datasource.matches.datasource.ITeamDataSource
import com.lucascoelho.csgomatches.datasource.matches.datasource.MatchesDataSource
import com.lucascoelho.csgomatches.datasource.matches.datasource.TeamDataSource
import com.lucascoelho.csgomatches.datasource.matches.repository.IMatchesRepository
import com.lucascoelho.csgomatches.datasource.matches.repository.ITeamRepository
import com.lucascoelho.csgomatches.datasource.matches.repository.MatchesRepository
import com.lucascoelho.csgomatches.datasource.matches.repository.TeamRepository
import org.koin.dsl.module

object RepositoryDI {
    val module = module {
        single<IMatchesDataSource> {
            MatchesDataSource(
                client = get() as MatchesClient
            )
        }

        single<ITeamDataSource> {
            TeamDataSource(
                client = get() as MatchesClient
            )
        }

        single<IMatchesRepository> {
            MatchesRepository(
                matchesDataSource = get() as IMatchesDataSource
            )
        }

        single<ITeamRepository> {
            TeamRepository(
                teamDataSource = get() as ITeamDataSource
            )
        }
    }
}
