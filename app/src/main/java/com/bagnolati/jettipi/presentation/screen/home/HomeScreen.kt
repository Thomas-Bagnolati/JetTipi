package com.bagnolati.jettipi.presentation.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bagnolati.jettipi.presentation.theme.AppTheme

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.state
    HomeScreenView(state)
}

@Composable
fun HomeScreenView(state: HomeState) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colors.background)
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "country is ... ${state.countries?.random()?.name}",
            style = AppTheme.typography.h1
        )
    }
}


@Preview
@Composable
fun HomePreview(
    state: HomeState = HomeState(
        isLoading = false,
        error = null,
        dialogIsVisible = false,
        countries = null
    )
) {
    MaterialTheme() {
        HomeScreenView(state)
    }
}