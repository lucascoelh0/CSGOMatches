package com.lucascoelho.csgomatches.matches.usecases

import com.lucascoelho.csgomatches.datasource.matches.entities.model.MatchModel
import com.lucascoelho.csgomatches.datasource.matches.repository.IMatchesRepository

class GetMatchesUseCaseImpl(private val matchesRepository: IMatchesRepository) : IGetMatchesUseCase {
    override suspend fun invoke(): List<MatchModel> {
        return matchesRepository.getAllMatches()
    }
}
