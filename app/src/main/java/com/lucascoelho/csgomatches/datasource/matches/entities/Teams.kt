package com.lucascoelho.csgomatches.datasource.matches.entities

data class Teams(
    val image_url: String,
    val name: String,
    val players: List<Player>
)
