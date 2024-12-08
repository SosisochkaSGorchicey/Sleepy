package com.feature.notification.presentation.add

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import com.feature.notification.presentation.add.components.AddNotificationScreenUI
import com.feature.notification.presentation.add.screenmodel.AddNotificationScreenModel
import org.orbitmvi.orbit.compose.collectAsState

object AddNotificationScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel = getScreenModel<AddNotificationScreenModel>()
        val state = viewModel.collectAsState().value

        AddNotificationScreenUI(
            state = state,
            onEvent = viewModel::onEvent
        )
    }
}