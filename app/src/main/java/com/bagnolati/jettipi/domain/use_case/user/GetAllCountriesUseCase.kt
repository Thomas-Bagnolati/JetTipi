package com.bagnolati.jettipi.domain.use_case.user

import com.bagnolati.jettipi.common.ErrorConstants.ERROR_MESSAGE_DEFAULT
import com.bagnolati.jettipi.common.ErrorConstants.ERROR_MESSAGE_NETWORK
import com.bagnolati.jettipi.common.Resource
import com.bagnolati.jettipi.data.remote.dto.toCountries
import com.bagnolati.jettipi.domain.model.Country
import com.bagnolati.jettipi.domain.repository.CountryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAllCountriesUseCase @Inject constructor(
    private val repository: CountryRepository
) {
    operator fun invoke(): Flow<Resource<List<Country>>> = flow {
        try {
            emit(Resource.Loading())
            val countries = repository.getCountry().toCountries()
            emit(Resource.Success(countries))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: ERROR_MESSAGE_DEFAULT))
        } catch (e: IOException) {
            emit(Resource.Error(ERROR_MESSAGE_NETWORK))
        }
    }
}