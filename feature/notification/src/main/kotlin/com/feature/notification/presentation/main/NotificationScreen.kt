package com.feature.notification.presentation.main

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.feature.notification.presentation.add.AddNotificationScreen
import com.feature.notification.presentation.main.components.NotificationScreenUI
import com.feature.notification.presentation.main.screenmodel.NotificationScreenModel
import com.feature.notification.presentation.main.screenmodel.NotificationSideEffect
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

object NotificationScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel = getScreenModel<NotificationScreenModel>()
        val state = viewModel.collectAsState().value
        val navigator = LocalNavigator.currentOrThrow

        NotificationScreenUI(
            state = state,
            onEvent = viewModel::onEvent
        )

        viewModel.collectSideEffect { sideEffect ->
            when (sideEffect) {
                NotificationSideEffect.NavigateToAddScreen -> navigator.push(AddNotificationScreen)
            }
        }
    }
}