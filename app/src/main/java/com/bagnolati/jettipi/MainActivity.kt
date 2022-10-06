package com.bagnolati.jettipi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bagnolati.jettipi.presentation.screen.Screen
import com.bagnolati.jettipi.presentation.screen.home.HomeScreen
import com.bagnolati.jettipi.presentation.screen.splash.SplashScreen
import com.bagnolati.jettipi.presentation.theme.AppTheme
import com.bagnolati.jettipi.presentation.theme.ConfigUI
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = AppTheme.colors.background
                ) {
                    val navController = rememberNavController()

                    ConfigUI(window, this)

                    NavHost(
                        navController = navController,
                        startDestination = Screen.Splash.route
                    ) {
                        composable(route = Screen.Splash.route) {
                            SplashScreen(navController)
                        }
                        composable(route = Screen.Home.route) {
                            HomeScreen(navController)
                        }
                    }
                }
            }

        }
    }
}