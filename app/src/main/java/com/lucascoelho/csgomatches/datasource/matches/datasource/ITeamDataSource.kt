package com.lucascoelho.csgomatches.datasource.matches.datasource

import com.lucascoelho.csgomatches.datasource.matches.entities.Teams

interface ITeamDataSource {
    suspend fun getTeamDetails(id: Int): List<Teams>
}
