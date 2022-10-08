package com.bagnolati.jettipi.presentation.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color


val Black = Color(0xFF151816)
val White = Color(0xFFFFFFFF)
val Transparent = Color(0x00000000)

val Gray25 = Color(0xFFF8F8F8)
val Gray50 = Color(0xFFF1F1F1)
val Gray75 = Color(0xFFECECEC)
val Gray100 = Color(0xFFE1E1E1)
val Gray200 = Color(0xFFEEEEEE)
val Gray300 = Color(0xFFACACAC)
val Gray400 = Color(0xFF919191)
val Gray500 = Color(0xFF6E6E6E)
val Gray600 = Color(0xFF535353)
val Gray700 = Color(0xFF616161)
val Gray800 = Color(0xFF292929)
val Gray900 = Color(0xFF212121)
val Gray950 = Color(0xFF141414)

val Blue = Color(0xFF6200EE)
val BlueDark = Color(0xFF3700B3)
val Red = Color(0xFFD13438)
val RedDark = Color(0xFF982626)

val CardDark = Color(0xFF3B3E43)
val CardLight = White

val BackgroundLight = Color(0xFFF5F2F5)
val BackgroundDark = Color(0xFF24292E)

val DividerLight = Color(0xFFE0E0E0)
val DividerDark = Color(0xFF6E6E6E)


@Immutable
data class AppColors(
    val primary: Color,
    val secondary: Color,
    val background: Color,
    val textPrimary: Color,
    val onPrimary: Color,
    val onBackground: Color,
    val isLight: Boolean,
    val navigationBackIcon: Color,
    val divider: Color,
    val inactive: Color = Gray500
)

val LightColors = AppColors(
    primary = Blue,
    secondary = Red,
    background = BackgroundLight,
    textPrimary = Black,
    onPrimary = White,
    onBackground = Black,
    isLight = true,
    navigationBackIcon = Gray900,
    divider = DividerDark
)

val DarkColors = AppColors(
    primary = Blue,
    secondary = Red,
    background = BackgroundDark,
    textPrimary = White,
    onPrimary = White,
    onBackground = White,
    isLight = false,
    navigationBackIcon = Gray100,
    divider = DividerLight
)


internal val LocalColors = staticCompositionLocalOf { LightColors }