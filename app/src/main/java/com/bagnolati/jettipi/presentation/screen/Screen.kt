package com.bagnolati.jettipi.presentation.screen

sealed class Screen(val route: String) {
    object Splash : Screen("Splash")
    object Home : Screen("Home")
}
