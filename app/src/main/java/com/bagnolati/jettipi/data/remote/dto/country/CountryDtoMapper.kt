package com.bagnolati.jettipi.data.remote.dto.country

import com.bagnolati.jettipi.domain.model.Country


fun CountryDto.toCountry(): Country {
    return Country(
        name = name,
        region = region,
        languageName = languagesDto.first().name,
        nativeLanguageName = languagesDto.first().nativeName,
        population = population,
        flag = flag,
        independent = independent,
        capital = capital
    )
}

fun List<CountryDto>.toCountries(): List<Country> {
    return map { it.toCountry() }
}