package com.lucascoelho.csgomatches.datasource.matches.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Team(
    val id: Int,
    val image_url: String,
    val name: String,
    val slug: String
) : Parcelable
