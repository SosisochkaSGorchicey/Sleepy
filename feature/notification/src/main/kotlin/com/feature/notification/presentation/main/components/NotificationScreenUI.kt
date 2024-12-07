package com.feature.notification.presentation.main.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.core.ui.theme.AppTheme
import com.core.ui.uiElements.LoadingDisplay
import com.core.ui.uiElements.mainScreenElements.FloatingButton
import com.core.ui.uiElements.mainScreenElements.MainBottomBar
import com.core.ui.uiElements.mainScreenElements.MainTopBar
import com.core.ui.uiElements.mainScreenElements.MoreIcon
import com.feature.notification.presentation.main.screenmodel.NotificationEvent
import com.feature.notification.presentation.main.screenmodel.NotificationScreenState
import com.feature.notification.presentation.main.screenmodel.NotificationState

@Composable
fun NotificationScreenUI(
    state: NotificationState,
    onEvent: (NotificationEvent) -> Unit
) {
    Scaffold(
        bottomBar = {
            MainBottomBar()
        },
        topBar = {
            MainTopBar(
                containerColor = AppTheme.colors.transparent,
                actions = {
                    MoreIcon(onClick = {})
                }
            )
        },
        floatingActionButton = {
            AnimatedVisibility( //todo вынести?
                visible = !state.showOnboardingCard,
                enter = fadeIn(animationSpec = spring(stiffness = Spring.StiffnessLow))
            ) {
                FloatingButton(onClick = { onEvent(NotificationEvent.OnAddButtonClick) })
            }
        },
        containerColor = AppTheme.colors.superLightPeachy,
        contentColor = AppTheme.colors.baseBlue
    ) { padding ->
        NotificationLayout(
            modifier = Modifier.padding(padding),
            state = state,
            onEvent = onEvent
        )

        when (state.screenState) {
            NotificationScreenState.Loading -> LoadingDisplay(
                layoutModifier = Modifier.padding(padding)
            )

            NotificationScreenState.Onboarding -> {
                AnimatedVisibility(
                    visible = state.showOnboardingCard,
                    exit = fadeOut(animationSpec = spring(stiffness = Spring.StiffnessLow)) //todo вынести?
                ) {
                    OnboardingCard(
                        modifier = Modifier.padding(padding),
                        onClick = { onEvent(NotificationEvent.OnOnboardingCardClick) }
                    )
                }
            }

            NotificationScreenState.Usual -> {}
        }
    }
}