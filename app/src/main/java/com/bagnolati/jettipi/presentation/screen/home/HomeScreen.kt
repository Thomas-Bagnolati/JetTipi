package com.bagnolati.jettipi.presentation.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.bagnolati.jettipi.domain.model.Country
import com.bagnolati.jettipi.presentation.component.LoadingView
import com.bagnolati.jettipi.presentation.theme.AppTheme
import com.bagnolati.jettipi.util.visibilityCondition

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.state
    HomeScreenView(
        state,
        onRefresh = viewModel::refreshRandomCountry
    )
}

@Composable
fun HomeScreenView(
    state: HomeState,
    onRefresh: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colors.background),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {

        CountryImage(state.country?.flag)

        Column() {
            Text(
                modifier = Modifier
                    .visibilityCondition(state.countries != null)
                    .align(Alignment.Start),
                text = state.country?.name ?: "",
                style = AppTheme.typography.h1
            )
            Spacer(modifier = Modifier.weight(1f))
            Button(onClick = onRefresh) {
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
    AsyncImage(
        modifier = Modifier
            .heightIn(max = 300.dp)
            .fillMaxWidth(),
        model = ImageRequest.Builder(LocalContext.current)
            .data(flagUrl)
            .decoderFactory(SvgDecoder.Factory())
            .build(),
        contentDescription = null,
        contentScale = ContentScale.FillWidth
    )
}


@Preview
@Composable
fun HomePreview(
    state: HomeState = HomeState(
        isLoading = false,
        error = null,
        dialogIsVisible = false,
        countries = null,
        country = Country(
            name = "France",
            region = "Europe",
            population = null,
            languages = listOf(
                Country.Language(name = "Français")
            ),
            capitale = "Paris",
            independent = true,
            flag = "link"
        )
    ),
) {
    HomeScreenView(
        state,
        onRefresh = {},
    )
}

