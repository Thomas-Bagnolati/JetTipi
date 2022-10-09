package com.bagnolati.jettipi.domain.model

data class Country(
    val name: String,
    val region: String,
    val population: Int?,
    val capital: String?,
    val independent: Boolean,
    val languageName: String,
    val nativeLanguageName: String? = null,
    val flag: String
)