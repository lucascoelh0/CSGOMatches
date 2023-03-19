package com.lucascoelho.csgomatches.matches.usecases

import com.lucascoelho.csgomatches.datasource.matches.entities.MatchStatus
import com.lucascoelho.csgomatches.datasource.matches.entities.model.MatchModel
import com.lucascoelho.csgomatches.datasource.matches.repository.IMatchesRepository

class GetMatchesUseCaseImpl(private val matchesRepository: IMatchesRepository) :
    IGetMatchesUseCase {
    override suspend fun invoke(): List<MatchModel> {
        val matchesList = mutableListOf<MatchModel>()
        matchesList.addAll(matchesRepository.getAllMatches())
        matchesList.removeIf {
            it.status == MatchStatus.NO_STATUS ||
                    it.status == MatchStatus.CANCELED ||
                    it.status == MatchStatus.UNKNOWN
        }
        matchesList.sortWith(compareBy({ it.status }, { it.scheduledAt }))
        return matchesList
    }
}
