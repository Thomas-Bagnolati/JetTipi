package com.bagnolati.jettipi.presentation.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp

@Immutable
data class AppShapes(
    val small: RoundedCornerShape = RoundedCornerShape(4.dp),
    val medium: RoundedCornerShape = RoundedCornerShape(8.dp),
    val large: RoundedCornerShape = RoundedCornerShape(16.dp),
    val full: RoundedCornerShape = RoundedCornerShape(100),
    val dialog: RoundedCornerShape = RoundedCornerShape(22.dp),
    val buttonDialog: RoundedCornerShape = RoundedCornerShape(10.dp),
)

internal val LocalShape = staticCompositionLocalOf { AppShapes() }