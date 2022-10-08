package com.bagnolati.jettipi.util

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.alpha

fun Modifier.notClickable(): Modifier = composed {
    clickable(
        enabled = false,
        indication = null,
        interactionSource = remember { MutableInteractionSource() },
        onClick = { },
    )
}

fun Modifier.visibilityCondition(
    visible: Boolean = true
): Modifier {
    val alphaVisibility = if (visible) 1f else 0f
    return alpha(alphaVisibility)
}