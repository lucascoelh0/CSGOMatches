package com.lucascoelho.csgomatches.datasource.matches.datasource

import com.lucascoelho.csgomatches.datasource.matches.client.MatchesClient
import com.lucascoelho.csgomatches.datasource.matches.entities.Teams

class TeamDataSource(private val client: MatchesClient) : ITeamDataSource {
    override suspend fun getTeamDetails(id: Int): List<Teams> {
        return client.getTeamDetails(id = id)
    }
}
