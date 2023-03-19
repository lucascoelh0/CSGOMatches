package com.lucascoelho.csgomatches.datasource.matches.client

import com.lucascoelho.csgomatches.BuildConfig
import com.lucascoelho.csgomatches.datasource.matches.entities.Teams
import com.lucascoelho.csgomatches.datasource.matches.entities.response.MatchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MatchesClient {

    @GET("csgo/matches")
    suspend fun getAllMatches(
        @Query("token") token: String = BuildConfig.API_KEY
    ): List<MatchResponse>

    @GET("csgo/teams")
    suspend fun getTeamDetails(
        @Query("token") token: String = BuildConfig.API_KEY,
        @Query("filter[id]") id: Int
    ): List<Teams>
}
