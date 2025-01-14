package com.feature.notification.presentation.add

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.core.domain.model.localDB.ScheduleItem
import com.feature.notification.presentation.add.components.AddNotificationScreenUI
import com.feature.notification.presentation.add.screenmodel.AddNotificationScreenModel
import com.feature.notification.presentation.add.screenmodel.AddNotificationSideEffect
import org.koin.core.parameter.parametersOf
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

class AddNotificationScreen(
    private val scheduleItem: ScheduleItem?
) : Screen {
    @Composable
    override fun Content() {
        val viewModel =
            getScreenModel<AddNotificationScreenModel>(parameters = { parametersOf(scheduleItem) })
        val state = viewModel.collectAsState().value
        val navigator = LocalNavigator.currentOrThrow

        AddNotificationScreenUI(
            state = state,
            onEvent = viewModel::onEvent
        )

        viewModel.collectSideEffect { sideEffect ->
            when (sideEffect) {
                AddNotificationSideEffect.NavigateBack -> navigator.pop()
            }
        }
    }
}