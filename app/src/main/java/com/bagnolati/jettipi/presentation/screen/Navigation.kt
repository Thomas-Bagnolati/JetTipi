package com.bagnolati.jettipi.presentation.screen

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bagnolati.jettipi.presentation.screen.home.HomeScreen
import com.bagnolati.jettipi.presentation.screen.splash.SplashScreen


@Composable
fun ConfigNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route,
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController)
        }
        composable(route = Screen.Home.route) {
            HomeScreen(navController)
        }

    }
}