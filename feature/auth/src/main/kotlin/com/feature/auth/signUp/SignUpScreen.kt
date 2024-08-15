package com.feature.auth.signUp

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.core.common.navigation.SharedScreen
import com.core.common.navigation.screen
import com.core.ui.theme.AppTheme
import com.core.ui.uiElements.MainTopBar
import com.feature.auth.signUp.components.SignUpScreenUI
import com.feature.auth.signUp.screenmodel.SignUpEvent
import com.feature.auth.signUp.screenmodel.SignUpScreenModel
import com.feature.auth.signUp.screenmodel.SignUpSideEffect
import org.orbitmvi.orbit.compose.collectSideEffect

object SignUpScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel = getScreenModel<SignUpScreenModel>()
        val state by viewModel.state.collectAsState()

        Scaffold(
            containerColor = AppTheme.colors.baseBlue,
            topBar = {
                MainTopBar(
                    onNavigateBackClick = {
                        viewModel.onEvent(SignUpEvent.OnBackClick)
                    }
                )
            }
        ) {
            SignUpScreenUI(
                outerModifier = Modifier.padding(it),
                state = state,
                onEvent = viewModel::onEvent
            )
        }

        viewModel.collectSideEffect { sideEffect ->
            when (sideEffect) {
                SignUpSideEffect.NavigateBack -> navigator.pop()
                SignUpSideEffect.NavigateToHomeScreen -> navigator.replace(SharedScreen.Home.screen())
            }
        }
    }
}