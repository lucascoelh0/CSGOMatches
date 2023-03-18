package com.lucascoelho.csgomatches.matches.usecases

import com.lucascoelho.csgomatches.datasource.matches.entities.Match
import com.lucascoelho.csgomatches.datasource.matches.repository.IMatchesRepository

class GetMatchesUseCaseImpl(private val matchesRepository: IMatchesRepository) : IGetMatchesUseCase {
    override suspend fun invoke(): List<Match> {
        return matchesRepository.getAllMatches()
    }
}
