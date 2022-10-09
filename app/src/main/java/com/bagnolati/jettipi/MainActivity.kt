package com.bagnolati.jettipi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.bagnolati.jettipi.presentation.screen.ConfigNavigation
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
                    modifier = Modifier
                        .fillMaxSize()
                        .navigationBarsPadding(),
                    color = AppTheme.colors.background
                ) {
                    ConfigUI(window, this)
                    ConfigNavigation()
                }
            }
        }
    }
}