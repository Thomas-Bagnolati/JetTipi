package com.bagnolati.jettipi.presentation.screen.country

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bagnolati.jettipi.common.ErrorConstants.ERROR_MESSAGE_DEFAULT
import com.bagnolati.jettipi.common.Resource.*
import com.bagnolati.jettipi.domain.model.Country
import com.bagnolati.jettipi.domain.use_case.user.GetAllCountriesUseCase
import com.bagnolati.jettipi.presentation.screen.country.CountryEvent.OnClickRefresh
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class CountryViewModel @Inject constructor(
    private val getAllCountriesUseCase: GetAllCountriesUseCase
) : ViewModel() {

    var state by mutableStateOf(CountryState())
        private set

    private val countries = MutableStateFlow<List<Country>?>(emptyList())

    init {
        fetchAllCountries()
    }

    fun onEvent(event: CountryEvent) {
        when (event) {
            OnClickRefresh -> refreshRandomCountry()
        }
    }

    private fun fetchAllCountries() {
        getAllCountriesUseCase().onEach { result ->
            state = when (result) {
                is Success -> {
                    countries.value = result.data
                    CountryState(country = result.data?.random())
                }
                is Error -> CountryState(error = result.message ?: ERROR_MESSAGE_DEFAULT)
                is Loading -> CountryState(isLoading = true)
            }
        }.launchIn(viewModelScope)
    }

    private fun refreshRandomCountry() {
        val randomCountry = countries.value?.random()
        state = state.copy(country = randomCountry)
    }

}