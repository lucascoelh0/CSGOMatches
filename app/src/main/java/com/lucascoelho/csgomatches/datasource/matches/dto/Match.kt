package com.lucascoelho.csgomatches.datasource.matches.dto

data class Match(
    val id: Int,
    val league: League,
    val serie: Serie,
    val opponents: List<Opponent>,
    val scheduledAt: String,
    val status: String,
)
