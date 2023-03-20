package com.lucascoelho.csgomatches.matches.usecases

import com.lucascoelho.csgomatches.datasource.matches.entities.Player

interface IGetTeamDetailsUseCase {
    suspend fun invoke(id: Int): List<Player>
}
