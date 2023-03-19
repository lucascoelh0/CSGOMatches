package com.lucascoelho.csgomatches.datasource.matches.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Serie(
    val name: String?
) : Parcelable
