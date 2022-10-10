package com.bagnolati.jettipi.presentation.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


@Immutable
data class AppTypography(
    val h1: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold,
        fontSize = 36.sp,
    ),
    val h4: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
    ),
    val subtitle: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    ),
    val body: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    ),
    val button: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
    ),
    val caption: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
    )
)

private val instance = AppTypography()
val LightTypography = AppTypography(
    h1 = instance.h1.copy(color = OnBackGroundLight),
    h4 = instance.h4.copy(color = OnBackGroundLight),
    subtitle = instance.subtitle.copy(color = OnBackGroundLight),
    body = instance.body.copy(color = OnBackGroundLight),
    caption = instance.caption.copy(color = OnBackGroundLight),
)

val DarkTypography = AppTypography(
    h1 = instance.h1.copy(color = OnBackGroundDark),
    h4 = instance.h4.copy(color = OnBackGroundDark),
    subtitle = instance.subtitle.copy(color = OnBackGroundDark),
    body = instance.body.copy(color = OnBackGroundDark),
    caption = instance.caption.copy(color = OnBackGroundDark),
)


internal val LocalTypography = staticCompositionLocalOf { LightTypography }