package com.lucascoelho.csgomatches.datasource.matches.datasource

import com.lucascoelho.csgomatches.datasource.matches.entities.model.MatchModel

interface IMatchesDataSource {
    suspend fun getAllMatches(): List<MatchModel>
}
