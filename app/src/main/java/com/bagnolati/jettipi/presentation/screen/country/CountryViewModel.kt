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
import com.bagnolati.jettipi.presentation.screen.country.CountryEvent.OnClickRandomCountry
import com.bagnolati.jettipi.presentation.screen.country.CountryEvent.OnDialogDismiss
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
            OnClickRandomCountry -> refreshRandomCountry()
            OnDialogDismiss -> state = state.copy(error = null)
            else -> fetchAllCountries()
        }
    }

    private fun fetchAllCountries() {
        getAllCountriesUseCase().onEach { result ->
            state = when (result) {
                is Success -> {
                    countries.value = result.data
                    state.copy(country = result.data?.random(), isLoading = false)
                }
                is Error -> state.copy(error = result.message ?: ERROR_MESSAGE_DEFAULT, isLoading = false)
                is Loading -> state.copy(isLoading = true)
            }
        }.launchIn(viewModelScope)
    }

    private fun refreshRandomCountry() {
        state = state.copy(country = countries.value?.random())
    }

}