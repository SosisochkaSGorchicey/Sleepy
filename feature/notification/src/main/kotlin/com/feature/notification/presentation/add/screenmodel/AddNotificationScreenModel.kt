package com.feature.notification.presentation.add.screenmodel

import com.core.common.mvi.MviScreenModel

class AddNotificationScreenModel
    : MviScreenModel<AddNotificationState, AddNotificationSideEffect, AddNotificationEvent>(
    initialState = AddNotificationState()
) {
    override fun onEvent(event: AddNotificationEvent) {
        when (event) {
            is AddNotificationEvent.OnWeekItemClick -> TODO()
        }
    }
}