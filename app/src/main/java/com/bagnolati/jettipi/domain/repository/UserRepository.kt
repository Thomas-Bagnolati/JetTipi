package com.bagnolati.jettipi.domain.repository

import com.bagnolati.jettipi.data.remote.dto.UserDto

interface UserRepository {

    suspend fun getUser(): UserDto

}