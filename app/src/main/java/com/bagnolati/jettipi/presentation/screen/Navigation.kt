package com.bagnolati.jettipi.presentation.screen

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bagnolati.jettipi.presentation.screen.country.CountryScreen
import com.bagnolati.jettipi.presentation.screen.home.HomeScreen


@Composable
fun ConfigNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(route = Screen.Country.route) {
            CountryScreen(navController)
        }

    }
}