package com.bagnolati.jettipi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.bagnolati.jettipi.ui.theme.AppTheme
import com.bagnolati.jettipi.ui.theme.ConfigUI

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = AppTheme.colors.background
                ) {

                    // DestinationsNavHost(navGraph = NavGraphs.main, engine = rememberAnimatedNavHostEngine())
                    ConfigUI(window, this)


                }
            }

        }
    }
}