package com.bagnolati.jettipi.presentation.screen.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bagnolati.jettipi.common.ErrorConstants.ERROR_MESSAGE_DEFAULT
import com.bagnolati.jettipi.common.Resource.*
import com.bagnolati.jettipi.domain.use_case.user.GetAllCountriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllCountriesUseCase: GetAllCountriesUseCase
) : ViewModel() {

    var state by mutableStateOf(HomeState())
        private set

    init {
        getAllCountries()
    }

    private fun getAllCountries() {
        getAllCountriesUseCase().onEach { result ->
            state = when (result) {
                is Success -> state.copy(countries = result.data)
                is Error -> state.copy(error = result.message ?: ERROR_MESSAGE_DEFAULT)
                is Loading -> state.copy(isLoading = true)
            }
        }.launchIn(viewModelScope)
    }

}