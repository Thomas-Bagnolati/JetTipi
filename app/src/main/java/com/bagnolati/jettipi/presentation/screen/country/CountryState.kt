package com.bagnolati.jettipi.presentation.screen.country

import com.bagnolati.jettipi.domain.model.Country


data class CountryState(
    val isLoading: Boolean = false,
    val error: String? = null,

    val country: Country? = null
)