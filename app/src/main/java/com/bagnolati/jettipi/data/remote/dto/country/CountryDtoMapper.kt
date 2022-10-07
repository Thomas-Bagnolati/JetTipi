package com.bagnolati.jettipi.data.remote.dto.country

import com.bagnolati.jettipi.domain.model.Country


fun CountryDto.toCountry(): Country {
    return Country(
        name = name,
        region = region,
        languages = languages.toLanguages(),
        population = population
    )
}

fun List<CountryDto>.toCountries(): List<Country> {
    return map { it.toCountry() }
}

fun LanguageDto.toLanguage(): Country.Language {
    return Country.Language(
        name = name,
        nativeName = nativeName
    )
}

fun List<LanguageDto>.toLanguages(): List<Country.Language> {
    return map { it.toLanguage() }
}
