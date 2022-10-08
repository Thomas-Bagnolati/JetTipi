package com.bagnolati.jettipi.data.remote.dto.country


import com.google.gson.annotations.SerializedName

data class Flags(
    @SerializedName("svg")
    val svg: String,
    @SerializedName("png")
    val png: String
)