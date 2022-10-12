package com.bagnolati.jettipi.presentation.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color


val Black = Color(0xFF141414)
val White = Color(0xFFF3F3F3)
val Dark = Color(0xFF1D2345)
val Light = Color(0xFFF3F1F0)
val Transparent = Color(0x00000000)

val BlueRoyal = Color(0xFF3759D8)
val Green = Color(0xFF3AB795)
val GreenVariant = Color(0xFF20FC8F)

val Error = Color(0xFFFF4760)
val Success = Color(0xFF4ad991)

val BackgroundLight = Light
val BackgroundDark = Dark
val OnBackGroundLight = Black
val OnBackGroundDark = White
val TextDark = Dark
val TextLight = Light
val CardDark = Color(0xFF1F2225)
val CardLight = Color(0xFFE6E8EE)
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
    val primary: Color = BlueRoyal,
    val onPrimary: Color = Light,
    val secondary: Color = Green,
    val onSecondary: Color = Light,
    val error: Color = Error,
    val onError: Color = White,
    val background: Color,
    val onBackground: Color,
    val textTheme: Color,
    val isLight: Boolean,
    val navigationBackIcon: Color,
    val divider: Color,
    val inactive: Color = Gray500,
    val cardBackground: Color
)

val LightColors = AppColors(
    background = BackgroundLight,
    onBackground = OnBackGroundLight,
    textTheme = TextDark,
    navigationBackIcon = Gray900,
    divider = DividerDark,
    cardBackground = CardLight,
    isLight = true,
)

val DarkColors = AppColors(
    background = BackgroundDark,
    onBackground = OnBackGroundDark,
    textTheme = TextLight,
    navigationBackIcon = Gray100,
    divider = DividerLight,
    cardBackground = CardDark,
    isLight = false,
)

internal val LocalColors = staticCompositionLocalOf { LightColors }