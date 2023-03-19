package com.lucascoelho.csgomatches.datasource.matches.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Opponent(
    val opponent: Team
) : Parcelable
