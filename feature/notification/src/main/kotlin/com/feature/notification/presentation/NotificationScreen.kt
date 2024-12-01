package com.feature.notification.presentation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import com.feature.notification.presentation.components.NotificationScreenUI
import com.feature.notification.presentation.screenmodel.NotificationScreenModel
import org.orbitmvi.orbit.compose.collectAsState

object NotificationScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel = getScreenModel<NotificationScreenModel>()
        val state = viewModel.collectAsState().value

        NotificationScreenUI(
            state = state,
            onEvent = viewModel::onEvent
        )
    }
}