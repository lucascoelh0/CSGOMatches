package com.lucascoelho.csgomatches.datasource.matches.client

import com.lucascoelho.csgomatches.datasource.matches.entities.response.MatchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MatchesClient {

    @GET("csgo/matches")
    suspend fun getAllMatches(
        @Query("token") token: String = ""
    ): List<MatchResponse>
}
