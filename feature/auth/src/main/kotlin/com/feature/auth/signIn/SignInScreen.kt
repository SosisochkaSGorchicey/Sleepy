package com.feature.auth.signIn

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
import com.core.ui.uiElements.ErrorSnackbar
import com.core.ui.uiElements.LoadingDisplay
import com.feature.auth.signIn.components.SignInScreenUI
import com.feature.auth.signIn.screenmodel.SignInScreenModel
import com.feature.auth.signIn.screenmodel.SignInSideEffect
import org.orbitmvi.orbit.compose.collectSideEffect

object SignInScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel = getScreenModel<SignInScreenModel>()
        val state by viewModel.state.collectAsState()

        Scaffold(
            containerColor = AppTheme.colors.baseBlue
        ) { paddingValues ->
            SignInScreenUI(
                modifier = Modifier.padding(top = paddingValues.calculateTopPadding()),
                bottomSheetModifier = Modifier.padding(bottom = paddingValues.calculateBottomPadding()),
                state = state,
                onEvent = viewModel::onEvent
            )

            state.errorTextRes?.let {
                ErrorSnackbar(
                    modifier = Modifier.padding(paddingValues),
                    errorTextRes = it
                )
            }

            if (state.inLoading)
                LoadingDisplay(
                    layoutModifier = Modifier.padding(paddingValues)
                )
        }

        viewModel.collectSideEffect { sideEffect ->
            when (sideEffect) {
                SignInSideEffect.NavigateToHomeScreen -> navigator.replace(SharedScreen.Home.screen())
                SignInSideEffect.NavigateToSignUpScreen -> navigator.push(SharedScreen.SignUp.screen())
            }
        }
    }
}