package com.bagnolati.jettipi.presentation.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color


val Dark = Color(0xFF151816)
val Light = Color(0xFFFFFFFF)
val Transparent = Color(0x00000000)

val Blue = Color(0xFF467CDA)
val Purple = Color(0xFF6200EE)
val PurpleDark = Color(0xFF694D9B)
val BlueGreen = Color(0xFF75C2B3)
val BlueGreenDark = Color(0xFF32695F)

val CardDark = Color(0xFF3B3E43)
val CardLight = Color(0xFFC3CEDF)

val OnBackGroundLight = Dark
val OnBackGroundDark = Light

val BackgroundLight = Color(0xFFF5F2F5)
val BackgroundDark = Color(0xFF24292E)

val DividerLight = Color(0xFFEBEBEB)
val DividerDark = Color(0xFF6E6E6E)

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


@Immutable
data class AppColors(
    val primary: Color = Purple,
    val onPrimary: Color = Light,
    val secondary: Color = BlueGreen,
    val onSecondary: Color = Dark,
    val background: Color,
    val onBackground: Color,
    val isLight: Boolean,
    val navigationBackIcon: Color,
    val divider: Color,
    val inactive: Color = Gray500,
    val cardLightBackground: Color = CardLight,
    val cardDarkBackground: Color = CardDark
)

val LightColors = AppColors(
    background = BackgroundLight,
    onBackground = OnBackGroundLight,
    navigationBackIcon = Gray900,
    divider = DividerDark,
    isLight = true,
)

val DarkColors = AppColors(
    background = BackgroundDark,
    onBackground = OnBackGroundDark,
    navigationBackIcon = Gray100,
    divider = DividerLight,
    isLight = false,
)

internal val LocalColors = staticCompositionLocalOf { LightColors }