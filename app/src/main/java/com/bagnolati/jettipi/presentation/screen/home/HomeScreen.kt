package com.bagnolati.jettipi.presentation.screen.home

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import com.bagnolati.jettipi.presentation.component.ButtonLarge
import com.bagnolati.jettipi.presentation.screen.Screen
import com.bagnolati.jettipi.presentation.theme.AppTheme

@Composable
fun SplashScreen(
    navController: NavController
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = AppTheme.colors.background)
            .padding(vertical = AppTheme.spacing.verticalLarge),
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.padding(top = AppTheme.spacing.XXL),
            horizontalAlignment = CenterHorizontally,
        ) {
            Text(
                text = stringResource(id = R.string.app_name),
                style = AppTheme.typography.h1,
                color = AppTheme.colors.textTheme,
                textAlign = TextAlign.Center
            )
            Text(
                text = "version ${BuildConfig.VERSION_NAME}",
                style = AppTheme.typography.caption,
                textAlign = TextAlign.Center
            )
        }

        ButtonLarge(
            text = "Go to Random Country",
            onClick = { navController.navigate(Screen.Country.route) }
        )

    }

}

@Preview(showBackground = true, name = "Light Mode")
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark Mode")
@Composable
private fun SplashPreview() {
    AppTheme {
        SplashScreen(navController = rememberNavController())
    }

}