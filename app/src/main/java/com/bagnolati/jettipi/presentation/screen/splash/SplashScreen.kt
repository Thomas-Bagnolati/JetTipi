package com.bagnolati.jettipi.presentation.screen.splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bagnolati.jettipi.BuildConfig
import com.bagnolati.jettipi.R
import com.bagnolati.jettipi.presentation.screen.Screen
import com.bagnolati.jettipi.presentation.theme.AppTheme

@Composable
fun SplashScreen(
    navController: NavController
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            style = AppTheme.typography.h1,
            textAlign = TextAlign.Center
        )
        Text(
            text = "version ${BuildConfig.VERSION_NAME}",
            style = AppTheme.typography.caption,
            textAlign = TextAlign.Center
        )
        Button(
            onClick = { navController.navigate(Screen.Home.route) }
        ) {
            Text(text = "Go to Home")
        }
    }

}

@Preview
@Composable
private fun SplashPreview() {

    SplashScreen(navController = rememberNavController())

}