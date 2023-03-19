package com.lucascoelho.csgomatches.matches.usecases

import com.lucascoelho.csgomatches.datasource.matches.entities.Player
import com.lucascoelho.csgomatches.datasource.matches.repository.ITeamRepository

class GetTeamDetailsUseCaseImpl(private val teamRepository: ITeamRepository) :
    IGetTeamDetailsUseCase {
    override suspend fun getTeamDetails(id: Int): List<Player> {
        val players = teamRepository.getTeamDetails(id)
        if (players.isNotEmpty()) {
            return players[0].players
        }
        return emptyList()
    }
}