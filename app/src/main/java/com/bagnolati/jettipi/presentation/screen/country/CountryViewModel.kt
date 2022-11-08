package com.bagnolati.jettipi.presentation.screen.country

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
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class CountryViewModel @Inject constructor(
    private val getAllCountriesUseCase: GetAllCountriesUseCase
) : ViewModel() {

    private var _state = MutableStateFlow(CountryState())
    val state = _state.asStateFlow()

    private val countries = MutableStateFlow<List<Country>?>(emptyList())

    init {
        fetchAllCountries()
    }

    fun onEvent(event: CountryEvent) {
        when (event) {
            OnClickRandomCountry -> refreshRandomCountry()
            OnDialogDismiss -> _state.value = state.value.copy(error = null)
            else -> fetchAllCountries()
        }
    }

    private fun fetchAllCountries() {
        getAllCountriesUseCase().onEach { result ->
            _state.value = when (result) {
                is Success -> {
                    countries.value = result.data
                    state.value.copy(country = result.data?.random(), isLoading = false)
                }
                is Error -> state.value.copy(error = result.message ?: ERROR_MESSAGE_DEFAULT, isLoading = false)
                is Loading -> state.value.copy(isLoading = true)
            }
        }.launchIn(viewModelScope)
    }

    private fun refreshRandomCountry() {
        _state.value = state.value.copy(country = countries.value?.random())
    }

}