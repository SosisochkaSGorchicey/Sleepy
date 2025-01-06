package com.feature.notification.presentation.main.components

import androidx.annotation.StringRes
import com.core.ui.R
import com.feature.notification.presentation.main.screenmodel.AlertDialog
import com.feature.notification.presentation.main.screenmodel.NotificationEvent

enum class DropDownItem(
    @StringRes val textRes: Int,
    val notificationEvent: NotificationEvent
) {
    Item1(
        textRes = R.string.drop_down_item_clear_day,
        notificationEvent = NotificationEvent.OnOpenAlertDialog(
            AlertDialog(
                warningTextRes = R.string.warning_item_clear_day,
                notificationEvent = NotificationEvent.OnClearCurrentDayClick
            )
        )
    ),
    Item2(
        textRes = R.string.drop_down_item_clear_all,
        notificationEvent = NotificationEvent.OnOpenAlertDialog(
            AlertDialog(
                warningTextRes = R.string.warning_item_clear_all,
                notificationEvent = NotificationEvent.OnDeleteAllClick
            )
        )
    )
}