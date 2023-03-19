package com.lucascoelho.csgomatches.matches.usecases

import com.lucascoelho.csgomatches.datasource.matches.entities.Player

interface IGetTeamDetailsUseCase {
    suspend fun getTeamDetails(id: Int): List<Player>
}
