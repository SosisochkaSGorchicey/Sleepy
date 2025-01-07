package com.feature.notification.presentation.main.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxState
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.core.domain.model.localDB.ScheduleItem
import com.core.ui.animations.defaultSpring
import com.core.ui.theme.AppTheme

@Composable
fun NotificationItemSwipeContainer(
    notificationItem: ScheduleItem,
    onItemClick: () -> Unit,
    onItemDelete: () -> Unit,
    dismiss: Boolean = false
) {
    val dismissState = rememberSwipeToDismissBoxState(
        confirmValueChange = {
            when (it) {
                SwipeToDismissBoxValue.EndToStart -> {
                    onItemDelete()
                    return@rememberSwipeToDismissBoxState true
                }

                else -> {
                    println("TAG: in else")
                    return@rememberSwipeToDismissBoxState false
                }
            }
        }
    )

    LaunchedEffect(key1 = dismiss) {
        if (dismiss) {
            dismissState.dismiss(SwipeToDismissBoxValue.Settled)
        }
    }

    SwipeToDismissBox(
        state = dismissState,
        backgroundContent = {
            DismissBackground(dismissState = dismissState)
        },
        content = {
            NotificationItemDisplay(
                notificationItem = notificationItem,
                onItemClick = onItemClick
            )
        },
        enableDismissFromStartToEnd = false
    )
}

@Composable
fun DismissBackground(dismissState: SwipeToDismissBoxState) {
    val backgroundColor by animateColorAsState(
        targetValue = if (dismissState.dismissDirection == SwipeToDismissBoxValue.EndToStart)
            AppTheme.colors.lightRed else AppTheme.colors.transparent,
        animationSpec = defaultSpring(),
        label = "backgroundColor"
    )

    val iconColor by animateColorAsState(
        targetValue = if (dismissState.dismissDirection == SwipeToDismissBoxValue.EndToStart)
            AppTheme.colors.milkyWhite else AppTheme.colors.transparent,
        animationSpec = defaultSpring(),
        label = "iconColor"
    )

    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {
        Icon(
            imageVector = Icons.Rounded.Delete,
            contentDescription = null,
            tint = iconColor
        )
    }
}