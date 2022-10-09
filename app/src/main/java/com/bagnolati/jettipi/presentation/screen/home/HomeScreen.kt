package com.bagnolati.jettipi.presentation.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.SubcomposeAsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.bagnolati.jettipi.domain.model.Country
import com.bagnolati.jettipi.presentation.component.LoadingView
import com.bagnolati.jettipi.presentation.theme.AppTheme

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.state
    HomeScreenView(
        state,
        onClickRefresh = viewModel::refreshRandomCountry
    )
}

@Composable
fun HomeScreenView(
    state: HomeState,
    onClickRefresh: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
        .background(AppTheme.colors.background),
    ) {

        CountryImage(state.country?.flag)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = AppTheme.spacing.horizontalDefault,
                    vertical = AppTheme.spacing.verticalDefault
                )
                .padding(top = 300.dp),
        ) {
            state.country?.let { country ->
                Text(
                    text = state.country.name,
                    style = AppTheme.typography.h1,
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "region : " + country.region)
                Text(text = "capitale : " + country.capital)
                Text(text = "independent : " + country.independent.toString())
                Text(text = "language : " + country.languageName)
                Text(text = "native language : " + country.nativeLanguageName)

            }

            Spacer(modifier = Modifier.weight(1f))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(AppTheme.spacing.buttonBoldHeight),
                shape = AppTheme.shapes.medium,

                onClick = onClickRefresh
            ) {
                Text(text = "Refresh")
            }
        }
    }
    when {
        state.isLoading -> LoadingView()
        state.error != null -> {}
    }
}

@Composable
private fun CountryImage(flagUrl: String?) {
    SubcomposeAsyncImage(
        modifier = Modifier
            .heightIn(max = 300.dp)
            .fillMaxWidth()
            .background(AppTheme.colors.cardBackground),
        model = ImageRequest.Builder(LocalContext.current)
            .data(flagUrl)
            .decoderFactory(SvgDecoder.Factory())
            .build(),
        contentDescription = null,
        contentScale = ContentScale.FillWidth,
        loading = {
            CircularProgressIndicator(
                modifier = Modifier.size(20.dp),
                color = AppTheme.colors.primary
            )
        }
    )
}


@Preview
@Composable
fun HomePreview() {
    val mokCountry = Country(
        name = "France",
        region = "Europe",
        population = null,
        languageName = "French",
        nativeLanguageName = "Français",
        capital = "Paris",
        independent = true,
        flag = "link"
    )
    val mokCountries = listOf(mokCountry)

    val state: HomeState = HomeState(
        isLoading = false,
        error = null,
        dialogIsVisible = false,
        countries = mokCountries,
        country = mokCountry,
    )
    MaterialTheme() {
        HomeScreenView(
            state,
            onClickRefresh = {},
        )
    }
}

