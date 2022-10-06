package com.bagnolati.jettipi.data.repository

import com.bagnolati.jettipi.data.remote.api.UserApi
import com.bagnolati.jettipi.data.remote.dto.UserDto
import com.bagnolati.jettipi.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: UserApi
) : UserRepository {
    override suspend fun getUser(): UserDto {
        return api.getUser()
    }
}