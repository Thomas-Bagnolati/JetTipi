package com.bagnolati.jettipi.presentation.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bagnolati.jettipi.BuildConfig
import com.bagnolati.jettipi.presentation.theme.AppColors
import com.bagnolati.jettipi.presentation.theme.AppTheme

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    Box(modifier = Modifier.fillMaxSize()
        .background(AppTheme.colors.secondary)) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "${BuildConfig.BASE_URL}", style = AppTheme.typography.h1
        )
    }
}
