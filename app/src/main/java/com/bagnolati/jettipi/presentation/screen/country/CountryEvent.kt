package com.bagnolati.jettipi.presentation.screen.country


sealed class CountryEvent {

    object OnClickRandomCountry : CountryEvent()
    object OnDialogDismiss : CountryEvent()
    object OnClickErrorDialog : CountryEvent()

}