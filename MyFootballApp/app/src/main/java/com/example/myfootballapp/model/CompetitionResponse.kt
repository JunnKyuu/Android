package com.example.myfootballapp.model

data class CompetitionResponse(
    val area: Area,
    val id: Int,
    val name: String,
    val code: String,
    val type: String,
    val emblem: String,
    val currentSeason: Season,
    val seasons: List<Season>,
    val lastUpdated: String
)