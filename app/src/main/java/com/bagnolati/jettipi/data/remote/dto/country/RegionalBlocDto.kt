package com.bagnolati.jettipi.data.remote.dto.country


import com.google.gson.annotations.SerializedName

data class RegionalBlocDto(
    @SerializedName("acronym")
    val acronym: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("otherNames")
    val otherNames: List<String>?,
    @SerializedName("otherAcronyms")
    val otherAcronyms: List<String>?
)