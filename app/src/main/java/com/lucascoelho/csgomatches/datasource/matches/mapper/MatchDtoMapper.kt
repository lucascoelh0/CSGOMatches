package com.lucascoelho.csgomatches.datasource.matches.mapper

import com.lucascoelho.csgomatches.datasource.matches.entities.MatchStatus
import com.lucascoelho.csgomatches.datasource.matches.entities.response.MatchResponse
import com.lucascoelho.csgomatches.datasource.matches.entities.model.MatchModel

fun MatchResponse.toModel() = MatchModel(
    id = id,
    league = league,
    serie = serie,
    opponents = opponents,
    scheduledAt = scheduled_at,
    status = MatchStatus.get(status)
)

fun List<MatchResponse>.toModel(): List<MatchModel> = map { it.toModel() }
