package com.bagnolati.jettipi.presentation.screen.country

import android.content.res.Configuration
import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.bagnolati.jettipi.domain.model.Country
import com.bagnolati.jettipi.presentation.component.ButtonLarge
import com.bagnolati.jettipi.presentation.component.LoadingView
import com.bagnolati.jettipi.presentation.screen.country.CountryEvent.OnClickRefresh
import com.bagnolati.jettipi.presentation.theme.AppTheme
import com.bagnolati.jettipi.util.toNumberFormat

@Composable
fun CountryScreen(
    navController: NavController,
    viewModel: CountryViewModel = hiltViewModel()
) {
    val state = viewModel.state

    CountryView(
        state,
        onClickRefresh = { viewModel.onEvent(OnClickRefresh) }
    )
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun CountryView(
    state: CountryState,
    onClickRefresh: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = AppTheme.colors.background)
            .padding(bottom = AppTheme.spacing.verticalLarge),
    ) {

        AnimatedContent(
            targetState = state.country,
            transitionSpec = { fadeIn() with fadeOut() }
        ) { animatedCountry ->

            animatedCountry?.let {
                Column {
                    CountryImageFlag(flagUrl = it.flag)
                    CountryInfos(country = it)
                }
            }

        }

        ButtonLarge(
            modifier = Modifier.align(BottomCenter),
            text = "Refresh",
            onClick = onClickRefresh
        )

    }
    when {
        state.isLoading -> LoadingView()
        state.error != null -> {}
    }

}

@Composable
private fun CountryInfos(
    modifier: Modifier = Modifier,
    country: Country
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = AppTheme.spacing.verticalDefault, horizontal = AppTheme.spacing.horizontalDefault),
    ) {
        Spacer(modifier = Modifier.height(AppTheme.spacing.L))
        Text(text = country.name, style = AppTheme.typography.h1, textAlign = TextAlign.Center, maxLines = 1, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(AppTheme.spacing.L))
        KeyValueText(key = "Region", value = country.region)
        KeyValueText(key = "Capitale ", value = country.capital ?: "unknown")
        KeyValueText(key = "Independent", value = country.independent.toString())
        KeyValueText(key = "Language", value = country.languageName)
        KeyValueText(key = "Native language", value = country.nativeLanguageName ?: "unknown")
        KeyValueText(key = "Population", value = country.population.toString().toNumberFormat())
    }
}

@Composable
private fun KeyValueText(
    key: String,
    value: String,
    style: TextStyle = AppTheme.typography.body
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 6.dp),
        contentAlignment = Alignment.BottomStart
    ) {
        Text(
            text = key,
            style = AppTheme.typography.h4
        )
        Text(
            modifier = Modifier
                .align(TopCenter),
            text = value,
            textAlign = TextAlign.Start,
            style = style
        )
    }

}

@Composable
private fun CountryImageFlag(
    modifier: Modifier = Modifier,
    flagUrl: String?
) {
    AsyncImage(
        modifier = modifier
            .height(300.dp)
            .fillMaxWidth()
            .background(AppTheme.colors.cardDarkBackground),
        model = ImageRequest.Builder(LocalContext.current)
            .data(flagUrl)
            .decoderFactory(SvgDecoder.Factory())
            .build(),
        contentDescription = null,
        contentScale = ContentScale.Crop,
    )
}


@Preview(showBackground = true, name = "Light Mode")
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark Mode")
@Composable
private fun CountryPreview() {
    val mokCountry = Country(
        name = "France",
        region = "Europe",
        population = 67_032_000,
        languageName = "French",
        nativeLanguageName = "Français",
        capital = "Paris",
        independent = true,
        flag = "link"
    )
    val mokCountries = listOf(mokCountry)
    val state = CountryState(
        isLoading = false,
        error = null,
        dialogIsVisible = false,
        countries = mokCountries,
        country = mokCountry,
    )
    AppTheme {
        CountryView(
            state,
            onClickRefresh = {},
        )
    }

}