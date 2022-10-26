package com.bagnolati.jettipi.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bagnolati.jettipi.presentation.theme.AppTheme
import com.bagnolati.jettipi.util.notClickable


@Composable
fun LoadingView(clickable: Boolean = false) {
    val modifier = Modifier
        .fillMaxSize()
        .background(color = AppTheme.colors.inactive.copy(alpha = 0.7f))

    Box(
        modifier = if (clickable) modifier else modifier.notClickable(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            color = AppTheme.colors.primary,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview(){
    LoadingView()
}