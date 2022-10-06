package com.bagnolati.jettipi.presentation.screen.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.bagnolati.jettipi.presentation.screen.Screen
import com.bagnolati.jettipi.presentation.theme.AppTheme

@Composable
fun SplashScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colors.primary),
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "SplashScreen", style = AppTheme.typography.h1
        )
        Button(
            onClick = { navController.navigate(Screen.Home.route) }
        ) {
            Text(text = "Go to Home")

        }
    }
}