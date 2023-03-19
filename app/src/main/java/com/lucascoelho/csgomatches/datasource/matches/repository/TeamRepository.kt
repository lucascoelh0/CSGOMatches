package com.lucascoelho.csgomatches.datasource.matches.repository

import com.lucascoelho.csgomatches.datasource.matches.datasource.ITeamDataSource
import com.lucascoelho.csgomatches.datasource.matches.entities.Teams

class TeamRepository(private val teamDataSource: ITeamDataSource) : ITeamRepository {
    override suspend fun getTeamDetails(id: Int): List<Teams> {
        return teamDataSource.getTeamDetails(id)
    }
}