package com.bagnolati.jettipi.util

import java.util.*

fun String.uppercaseOnEachWord(): String {
    return this
        .split(" ")
        .joinToString(separator = " ") {
            it.replaceFirstChar { char ->
                if (char.isLowerCase()) char.titlecase(Locale.getDefault())
                else char.toString()
            }
        }
}

fun String.capitalize(): String {
    return this.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
}