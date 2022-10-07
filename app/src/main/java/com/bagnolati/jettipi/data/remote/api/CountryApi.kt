package com.bagnolati.jettipi.data.remote.api

import com.bagnolati.jettipi.data.remote.dto.country.CountryDto
import retrofit2.http.GET

const val COUNTRY_API_VERSION = "/v2"

interface CountryApi {

    @GET("$COUNTRY_API_VERSION/all")
    suspend fun getAllCountries(): List<CountryDto>

}