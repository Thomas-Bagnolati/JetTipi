package com.bagnolati.jettipi.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.bagnolati.jettipi.presentation.theme.AppTheme
import com.bagnolati.jettipi.util.notClickable


@Composable
fun LoadingView(clickable: Boolean = false) {
    val modifier =
        if (clickable) Modifier
            .fillMaxSize()
            .background(color = AppTheme.colors.inactive.copy(alpha = 0.6f))
            .notClickable()
        else Modifier
            .fillMaxSize()
            .background(color = AppTheme.colors.inactive.copy(alpha = 0.6f))

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            color = AppTheme.colors.primary,
        )

    }
}