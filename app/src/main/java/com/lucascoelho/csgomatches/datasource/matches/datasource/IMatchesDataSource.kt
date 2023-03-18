package com.lucascoelho.csgomatches.datasource.matches.datasource

import com.lucascoelho.csgomatches.datasource.matches.entities.Match

interface IMatchesDataSource {
    suspend fun getAllMatches(): List<Match>
}
