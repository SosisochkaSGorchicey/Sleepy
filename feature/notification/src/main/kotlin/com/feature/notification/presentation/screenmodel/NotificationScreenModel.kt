package com.feature.notification.presentation.screenmodel

import com.core.common.mvi.MviScreenModel
import com.core.common.mvi.reducer
import com.core.domain.repository.DataStoreRepository
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce

class NotificationScreenModel(
    private val dataStoreRepository: DataStoreRepository
) : MviScreenModel<NotificationState, NotificationSideEffect, NotificationEvent>(
    initialState = NotificationState()
) {

    init {
        decideScreenState()
    }

    override fun onEvent(event: NotificationEvent) {
        when (event) {
            NotificationEvent.OnOnboardingCardClick -> onboardingCardDisappear()
        }
    }

    private fun onboardingCardDisappear() =
        reducer { state.copy(showOnboardingCard = false) }

    private fun decideScreenState() = intent {
        dataStoreRepository.notificationOnboardingCompleted().collect {
            reduce {
                state.copy(
                    screenState = if (it) NotificationScreenState.Usual
                    else NotificationScreenState.Onboarding
                )
            }
        }
    }
}