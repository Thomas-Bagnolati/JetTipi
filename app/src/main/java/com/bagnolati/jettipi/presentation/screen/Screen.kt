package com.bagnolati.jettipi.presentation.screen

sealed class Screen(val route: String) {
    object Home : Screen("Home")
    object Country : Screen("Country")
}
