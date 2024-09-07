package com.feature.home.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.core.ui.theme.AppTheme
import com.core.ui.uiElements.ErrorSnackbar
import com.core.ui.uiElements.mainScreenElements.AccountIcon
import com.core.ui.uiElements.mainScreenElements.MainBottomBar
import com.core.ui.uiElements.mainScreenElements.MainTopBar
import com.core.ui.uiElements.mainScreenElements.SettingsIcon
import com.feature.home.presentation.components.HomeScreenUI
import com.feature.home.presentation.screenmodel.HomeEvent
import com.feature.home.presentation.screenmodel.HomeScreenModel
import com.feature.home.presentation.screenmodel.HomeSideEffect
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

object HomeScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel = getScreenModel<HomeScreenModel>()
        val state = viewModel.collectAsState().value

        Scaffold(
            containerColor = AppTheme.colors.baseBlueLight,
            bottomBar = {
                MainBottomBar()
            },
            topBar = {
                MainTopBar(
                    titleText = "Hello, Alice!", //todo
                    navigationIcon = {
                        SettingsIcon(onClick = { viewModel.onEvent(HomeEvent.OnSettingsClick) })
                    },
                    actions = {
                        AccountIcon(onClick = { viewModel.onEvent(HomeEvent.OnAccountClick) })
                    }
                )
            }
        ) { padding ->
            HomeScreenUI(
                firstPaddings = Modifier.padding(top = padding.calculateTopPadding()),
                lastPaddings = Modifier.padding(bottom = padding.calculateBottomPadding()),
                state = state
            )

            state.errorTextRes?.let {
                ErrorSnackbar(
                    modifier = Modifier.padding(padding),
                    errorTextRes = it
                )
            }
        }

        viewModel.collectSideEffect {
            when (it) {
                HomeSideEffect.NavigateToAccount -> {} //todo
                HomeSideEffect.NavigateToSettings -> {} //todo
            }
        }
    }
}