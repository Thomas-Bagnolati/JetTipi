package com.bagnolati.jettipi.presentation.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bagnolati.jettipi.presentation.theme.AppTheme

@Composable
fun ButtonLarge(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier
            .fillMaxWidth(0.8f)
            .height(AppTheme.spacing.buttonBoldHeight),
        shape = AppTheme.shapes.medium,
        colors = ButtonDefaults.buttonColors(backgroundColor = AppTheme.colors.primary, contentColor = AppTheme.colors.onPrimary),
        onClick = onClick
    ) {
        Text(text = text, style = AppTheme.typography.button)
    }
}