package com.lucascoelho.csgomatches.datasource.matches.entities.model

import android.os.Parcelable
import com.lucascoelho.csgomatches.datasource.matches.entities.League
import com.lucascoelho.csgomatches.datasource.matches.entities.MatchStatus
import com.lucascoelho.csgomatches.datasource.matches.entities.Opponent
import com.lucascoelho.csgomatches.datasource.matches.entities.Serie
import kotlinx.parcelize.Parcelize

@Parcelize
data class MatchModel(
    val id: Int,
    val league: League,
    val serie: Serie,
    val opponents: List<Opponent>,
    val scheduledAt: String,
    val status: MatchStatus
) : Parcelable
