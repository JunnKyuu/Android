package com.example.myfootballapp.api

import com.example.myfootballapp.model.CompetitionResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface FootballApiService {
    @GET("competitions/PL")
    fun getCompetitionDetails(@Header("X-Auth-Token") authToken: String): Call<CompetitionResponse>
}
