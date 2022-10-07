package com.bagnolati.jettipi.data.repository

import com.bagnolati.jettipi.data.remote.api.CountryApi
import com.bagnolati.jettipi.data.remote.dto.country.CountryDto
import com.bagnolati.jettipi.domain.repository.CountryRepository
import javax.inject.Inject

class CountryRepositoryImpl @Inject constructor(
    private val api: CountryApi
) : CountryRepository {

    override suspend fun getCountry(): List<CountryDto> {
        return api.getAllCountries()
    }

}