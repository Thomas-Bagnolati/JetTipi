package com.bagnolati.jettipi.ui.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class AppSpacing(
    val XS: Dp = 4.dp,
    val S: Dp = 8.dp,
    val M: Dp = 16.dp,
    val L: Dp = 32.dp,
    val XL: Dp = 42.dp,
    val XXL: Dp = 64.dp,

    val horizontalDefault: Dp = 19.dp,
    val horizontalLarge: Dp = 24.dp,
    val verticalDefault: Dp = 8.dp,
    val verticalLarge: Dp = 24.dp,

    val buttonBoldHeight: Dp = 56.dp,
    val buttonSmallHeight: Dp = 36.dp
)

data class AppLetterSpacing(
    val default: TextUnit = 0.sp,
    val minS: TextUnit = (-0.3).sp,
    val minM: TextUnit = (-0.5).sp,
    val minL: TextUnit = (-1).sp,
    val plusS: TextUnit = 0.3.sp,
    val plusM: TextUnit = 0.5.sp,
    val plusL: TextUnit = 1.sp,
)

internal val LocalSpacing = compositionLocalOf { AppSpacing() }
internal val LocalLetterSpacing = compositionLocalOf { AppLetterSpacing() }