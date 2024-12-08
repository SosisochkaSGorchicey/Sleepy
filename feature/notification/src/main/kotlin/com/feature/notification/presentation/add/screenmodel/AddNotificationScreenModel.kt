package com.feature.notification.presentation.add.screenmodel

import com.core.common.mvi.MviScreenModel
import com.core.common.mvi.emitSideEffect
import com.feature.notification.model.WeekItem

class AddNotificationScreenModel
    : MviScreenModel<AddNotificationState, AddNotificationSideEffect, AddNotificationEvent>(
    initialState = AddNotificationState()
) {
    override fun onEvent(event: AddNotificationEvent) {
        when (event) {
            is AddNotificationEvent.OnWeekItemClick -> weekItemClickLogic(weekItem = event.clickedWeekItem)
            AddNotificationEvent.OnBackButtonClick -> emitSideEffect(AddNotificationSideEffect.NavigateBack)
        }
    }

    private fun weekItemClickLogic(weekItem: WeekItem) {

    }
}