package com.bagnolati.jettipi.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember

object AppTheme {

    val colors: AppColors
        @Composable @ReadOnlyComposable
        get() = LocalColors.current

    val typography: AppTypography
        @Composable @ReadOnlyComposable
        get() = LocalTypography.current

    val shapes: AppShapes
        @Composable @ReadOnlyComposable
        get() = LocalShape.current

    val spacing: AppSpacing
        @Composable @ReadOnlyComposable
        get() = LocalSpacing.current

    val letterSpacing: AppLetterSpacing
        @Composable @ReadOnlyComposable
        get() = LocalLetterSpacing.current

    val duration: AppDuration
        @Composable @ReadOnlyComposable
        get() = LocalDuration.current

}

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    spacing: AppSpacing = AppTheme.spacing,
    shapes: AppShapes = AppTheme.shapes,
    letterSpacing: AppLetterSpacing = AppTheme.letterSpacing,
    duration: AppDuration = AppTheme.duration,
    content: @Composable () -> Unit
) {

    val colors = if (darkTheme) DarkColors else LightColors
    val typo = if (darkTheme) DarkTypography else LightTypography
    val rememberedColors = remember { colors.copy() }

    CompositionLocalProvider(
        LocalColors provides rememberedColors,
        LocalTypography provides typo,
        LocalSpacing provides spacing,
        LocalShape provides shapes,
        LocalLetterSpacing provides letterSpacing,
        LocalDuration provides duration,
        content = content
    )
}