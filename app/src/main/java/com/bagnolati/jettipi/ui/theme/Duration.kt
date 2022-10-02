package com.bagnolati.jettipi.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.compositionLocalOf

@Immutable
data class AppDuration(
    val extraShort: Int = 200,
    val short: Int = 400,
    val medium: Int = 700,
    val long: Int = 1200,
    val extraLong: Int = 3000,

    val animatedView: Int = 300
)

val LocalDuration = compositionLocalOf { AppDuration() }