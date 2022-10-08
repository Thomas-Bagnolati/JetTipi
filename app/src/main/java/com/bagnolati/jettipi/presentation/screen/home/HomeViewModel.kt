package com.bagnolati.jettipi.presentation.screen.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bagnolati.jettipi.common.ErrorConstants.ERROR_MESSAGE_DEFAULT
import com.bagnolati.jettipi.common.Resource.*
import com.bagnolati.jettipi.domain.use_case.user.GetAllCountriesUseCase
import com.bagnolati.jettipi.presentation.screen.home.HomeEvent.OnRefreshRandomCountry
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllCountriesUseCase: GetAllCountriesUseCase
) : ViewModel() {

    var state by mutableStateOf(HomeState())
        private set

    private val _countries = MutableStateFlow<HomeState>(HomeState())
    val countries: StateFlow<HomeState> = _countries

    init {
        fetchAllCountries()
    }

    fun onEvent(event: HomeEvent) {
        when (event) {
            OnRefreshRandomCountry -> TODO()
        }
    }

    private fun fetchAllCountries() {
        getAllCountriesUseCase().onEach { result ->
            state = when (result) {
                is Success -> HomeState(countries = result.data)
                is Error -> HomeState(error = result.message ?: ERROR_MESSAGE_DEFAULT)
                is Loading -> HomeState(isLoading = true)
            }
        }.launchIn(viewModelScope)
    }

    fun refreshRandomCountry() {
        val randomCountry = state.countries?.random()
        state = state.copy(country = randomCountry)
    }

}