package com.bagnolati.jettipi.ui.theme

import android.app.Activity
import android.view.Window
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun ConfigUI(window: Window, activity: Activity) {

    WindowCompat.setDecorFitsSystemWindows(window, false)
    rememberSystemUiController().apply {
        setSystemBarsColor(Color.Transparent)
    }

    ViewCompat.setOnApplyWindowInsetsListener(activity.findViewById(android.R.id.content)) { view, insets ->
        val bottom = insets.getInsets(WindowInsetsCompat.Type.ime()).bottom
        view.updatePadding(bottom = bottom)
        insets
    }
}