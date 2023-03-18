package com.lucascoelho.csgomatches.datasource.matches.datasource

import com.lucascoelho.csgomatches.datasource.matches.client.MatchesClient
import com.lucascoelho.csgomatches.datasource.matches.entities.Match

class MatchesDataSource(private val client: MatchesClient) : IMatchesDataSource {
    override suspend fun getAllMatches(): List<Match> {
        return client.getAllMatches()
    }
}
