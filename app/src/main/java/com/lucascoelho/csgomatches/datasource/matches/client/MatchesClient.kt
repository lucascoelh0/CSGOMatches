package com.lucascoelho.csgomatches.datasource.matches.client

import retrofit2.http.GET

interface MatchesClient {

    @GET("csgo/matches")
    suspend fun getAllMatches()
}
