package com.bagnolati.jettipi.presentation.screen.home

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bagnolati.jettipi.common.Resource.*
import com.bagnolati.jettipi.domain.model.User
import com.bagnolati.jettipi.domain.use_case.user.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

const val HOME_STATE = "Home_State"
const val DEFAULT_ERROR_MESSAGE = "An unexpected error occurred"

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val safeStateHandle: SavedStateHandle,
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    val state = safeStateHandle.getStateFlow(HOME_STATE, HomeState())

    private fun getUser() {
        getUserUseCase().onEach { result ->
            safeStateHandle[HOME_STATE] = when (result) {
                is Success -> HomeState(user = result.data)
                is Error -> HomeState(error = result.message ?: DEFAULT_ERROR_MESSAGE)
                is Loading -> HomeState(isLoading = true)
            }
        }.launchIn(viewModelScope)
    }

}

data class HomeState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val dialogIsVisible: Boolean = false,
    val user: User? = null
)