package com.bagnolati.jettipi.domain.model

data class Country(
    val name: String,
    val region: String,
    val subRegion: String,
    val population: Int?,
    val capital: String?,
    val independent: Boolean,
    val languageNames: List<String>,
    val nativeLanguageName: String? = null,
    val flagUrl: String,
    val demonym: String,
    val timezones: String,
    val topLevelDomain: String,
    val alpha2Code: String
)