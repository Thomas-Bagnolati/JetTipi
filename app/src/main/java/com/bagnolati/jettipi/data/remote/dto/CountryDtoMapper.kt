package com.bagnolati.jettipi.data.remote.dto

import com.bagnolati.jettipi.data.remote.dto.country.CountryDto
import com.bagnolati.jettipi.domain.model.Country


fun CountryDto.toCountry(): Country {
    return Country(
        name = name,
        region = region,
        subRegion = subregion,
        languageNames = languagesDto.map { it.name },
        nativeLanguageName = languagesDto.first().nativeName,
        population = population,
        flagUrl = flag,
        independent = independent,
        capital = capital,
        alpha2Code = alpha2Code,
        demonym = demonym,
        timezones = timezones.first(),
        topLevelDomain = topLevelDomain.first()
    )
}

fun List<CountryDto>.toCountries(): List<Country> {
    return map { it.toCountry() }
}