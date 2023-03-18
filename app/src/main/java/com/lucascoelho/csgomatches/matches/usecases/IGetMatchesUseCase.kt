package com.lucascoelho.csgomatches.matches.usecases

import com.lucascoelho.csgomatches.datasource.matches.entities.model.MatchModel

interface IGetMatchesUseCase {
    suspend fun invoke(): List<MatchModel>
}
