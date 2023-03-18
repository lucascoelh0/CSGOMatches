package com.lucascoelho.csgomatches.datasource.matches.entities.response

import com.lucascoelho.csgomatches.datasource.matches.entities.League
import com.lucascoelho.csgomatches.datasource.matches.entities.Opponent
import com.lucascoelho.csgomatches.datasource.matches.entities.Serie

data class MatchResponse(
    val id: Int,
    val league: League,
    val serie: Serie,
    val opponents: List<Opponent>,
    val scheduled_at: String,
    val status: String
)
