package com.lucascoelho.csgomatches.matches.usecases

import com.lucascoelho.csgomatches.datasource.matches.entities.Match

interface IGetMatchesUseCase {
    suspend fun invoke(): List<Match>
}
