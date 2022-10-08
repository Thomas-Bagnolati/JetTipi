package com.bagnolati.jettipi.domain.model

data class Country(
    val name: String,
    val region: String,
    val population: Int?,
    val languages: List<Language>,
    val capitale: String?,
    val independent: Boolean,
    val flag: String
) {
    data class Language(
        val name: String,
        val nativeName: String? = null
    )
}