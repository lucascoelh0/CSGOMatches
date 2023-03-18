package com.lucascoelho.csgomatches.datasource.matches.repository

import com.lucascoelho.csgomatches.datasource.matches.entities.Match

interface IMatchesRepository {
    suspend fun getAllMatches(): List<Match>
}
