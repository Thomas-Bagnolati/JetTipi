package com.bagnolati.jettipi.data.remote.dto.country


import com.google.gson.annotations.SerializedName

data class CountryDto(
    @SerializedName("name")
    val name: String,
    @SerializedName("topLevelDomain")
    val topLevelDomain: List<String>,
    @SerializedName("alpha2Code")
    val alpha2Code: String,
    @SerializedName("alpha3Code")
    val alpha3Code: String,
    @SerializedName("callingCodes")
    val callingCodes: List<String>,
    @SerializedName("capital")
    val capital: String?,
    @SerializedName("altSpellings")
    val altSpellings: List<String>?,
    @SerializedName("subregion")
    val subregion: String,
    @SerializedName("region")
    val region: String,
    @SerializedName("population")
    val population: Int,
    @SerializedName("latlng")
    val latlng: List<Double>?,
    @SerializedName("demonym")
    val demonym: String,
    @SerializedName("area")
    val area: Double?,
    @SerializedName("timezones")
    val timezones: List<String>,
    @SerializedName("borders")
    val borders: List<String>?,
    @SerializedName("nativeName")
    val nativeName: String,
    @SerializedName("numericCode")
    val numericCode: String,
    @SerializedName("flags")
    val flagsDto: FlagsDto,
    @SerializedName("currencies")
    val currencies: List<CurrencyDto>?,
    @SerializedName("languages")
    val languagesDto: List<LanguageDto>,
    @SerializedName("translations")
    val translationsDto: TranslationsDto,
    @SerializedName("flag")
    val flag: String,
    @SerializedName("regionalBlocs")
    val regionalBlocDtos: List<RegionalBlocDto>?,
    @SerializedName("cioc")
    val cioc: String?,
    @SerializedName("independent")
    val independent: Boolean,
    @SerializedName("gini")
    val gini: Double?
)