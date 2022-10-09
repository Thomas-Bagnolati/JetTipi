package com.bagnolati.jettipi.data.remote.dto.country


import com.google.gson.annotations.SerializedName

data class FlagsDto(
    @SerializedName("svg")
    val svg: String,
    @SerializedName("png")
    val png: String
)