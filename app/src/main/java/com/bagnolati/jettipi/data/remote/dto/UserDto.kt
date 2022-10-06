package com.bagnolati.jettipi.data.remote.dto

import com.bagnolati.jettipi.domain.model.User
import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName("id")
    val id: String,
    @SerializedName("token")
    val token: String,
)

fun UserDto.toUser(): User {
    return User(
        id = id,
        token = token
    )
}