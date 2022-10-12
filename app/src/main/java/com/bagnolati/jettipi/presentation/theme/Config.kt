package com.bagnolati.jettipi.presentation.theme

import android.app.Activity
import android.view.Window
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun ConfigUI(window: Window, activity: Activity) {

    WindowCompat.setDecorFitsSystemWindows(window, false)
    rememberSystemUiController().apply {
        setSystemBarsColor(Color.Transparent)
        setNavigationBarColor(Color.Black)
    }
}