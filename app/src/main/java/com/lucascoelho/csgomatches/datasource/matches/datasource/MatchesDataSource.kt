package com.lucascoelho.csgomatches.datasource.matches.datasource

import com.lucascoelho.csgomatches.datasource.matches.client.MatchesClient
import com.lucascoelho.csgomatches.datasource.matches.entities.model.MatchModel
import com.lucascoelho.csgomatches.datasource.matches.mapper.toModel

class MatchesDataSource(private val client: MatchesClient) : IMatchesDataSource {
    override suspend fun getAllMatches(): List<MatchModel> {
        return client.getAllMatches().toModel()
    }
}
