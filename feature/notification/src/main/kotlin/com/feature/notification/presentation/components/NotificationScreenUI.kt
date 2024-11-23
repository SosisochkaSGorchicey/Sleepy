package com.feature.notification.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.core.ui.theme.AppTheme
import com.core.ui.uiElements.LoadingDisplay
import com.core.ui.uiElements.mainScreenElements.MainBottomBar
import com.feature.notification.presentation.screenmodel.NotificationEvent
import com.feature.notification.presentation.screenmodel.NotificationScreenState
import com.feature.notification.presentation.screenmodel.NotificationState

@Composable
fun NotificationScreenUI(
    state: NotificationState,
    onEvent: (NotificationEvent) -> Unit
) {
    Scaffold(
        bottomBar = {
            MainBottomBar()
        },
        containerColor = AppTheme.colors.baseGray,
        contentColor = AppTheme.colors.baseBlue
    ) { padding ->
        Text(text = "NotificationScreenUI")

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