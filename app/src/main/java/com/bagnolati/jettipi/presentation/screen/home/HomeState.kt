package com.bagnolati.jettipi.presentation.screen.home

import com.bagnolati.jettipi.domain.model.Country


data class HomeState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val dialogIsVisible: Boolean = false,
    val countries: List<Country>? = null
)