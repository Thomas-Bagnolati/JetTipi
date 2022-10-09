package com.bagnolati.jettipi.presentation.screen.country


sealed class CountryEvent {

    object OnClickRefresh : CountryEvent()

}