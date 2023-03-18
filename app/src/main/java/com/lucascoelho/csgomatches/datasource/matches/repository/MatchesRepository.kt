package com.lucascoelho.csgomatches.datasource.matches.repository

import com.lucascoelho.csgomatches.datasource.matches.datasource.IMatchesDataSource
import com.lucascoelho.csgomatches.datasource.matches.entities.model.MatchModel

class MatchesRepository(private val matchesDataSource: IMatchesDataSource) : IMatchesRepository {
    override suspend fun getAllMatches(): List<MatchModel> {
        return matchesDataSource.getAllMatches()
    }
}