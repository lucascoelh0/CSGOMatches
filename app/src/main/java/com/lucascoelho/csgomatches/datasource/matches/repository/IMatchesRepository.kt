package com.lucascoelho.csgomatches.datasource.matches.repository

import com.lucascoelho.csgomatches.datasource.matches.entities.model.MatchModel

interface IMatchesRepository {
    suspend fun getAllMatches(): List<MatchModel>
}
