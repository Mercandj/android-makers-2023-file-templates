package com.app

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val viewModel = createViewModel()
    Box(modifier = modifier) {

    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}

@Composable
private fun createViewModel(): HomeScreenViewModel {
    return viewModel(
        factory = viewModelFactory {
            initializer {
                HomeScreenViewModel()
            }
        }
    )
}


