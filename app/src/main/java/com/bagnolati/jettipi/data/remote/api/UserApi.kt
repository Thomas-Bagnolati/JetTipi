package com.bagnolati.jettipi.data.remote.api

import com.bagnolati.jettipi.data.remote.dto.UserDto
import retrofit2.http.GET

interface UserApi {

    @GET("/v1/user")
    suspend fun getUser(): UserDto


}