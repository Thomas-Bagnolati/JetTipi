package com.bagnolati.jettipi.domain.repository

import com.bagnolati.jettipi.data.remote.dto.country.CountryDto

interface CountryRepository {

    suspend fun getCountry(): List<CountryDto>

}