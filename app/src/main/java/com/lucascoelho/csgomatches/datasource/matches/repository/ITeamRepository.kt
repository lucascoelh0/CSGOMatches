package com.lucascoelho.csgomatches.datasource.matches.repository

import com.lucascoelho.csgomatches.datasource.matches.entities.Teams

interface ITeamRepository {
    suspend fun getTeamDetails(id: Int): List<Teams>
}
