package com.feature.notification.presentation.main.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.core.domain.model.localDB.ScheduleItem
import com.core.ui.theme.AppTheme

@Composable
fun NotificationItemSwipeContainer(
    notificationItem: ScheduleItem,
    onItemClick: () -> Unit,
    onItemDelete: () -> Unit
) {
    val dismissState = rememberSwipeToDismissBoxState(
        confirmValueChange = {
            when (it) {
                SwipeToDismissBoxValue.EndToStart -> {
                    onItemDelete()
                    return@rememberSwipeToDismissBoxState true
                }

                else -> return@rememberSwipeToDismissBoxState false
            }
        }
    )

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
fun DismissBackground(dismissState: SwipeToDismissBoxState) { //todo animated colors
    val backgroundColor by animateColorAsState(
        targetValue = if (dismissState.dismissDirection == SwipeToDismissBoxValue.EndToStart)
            AppTheme.colors.lightRed else AppTheme.colors.transparent,
        animationSpec = spring(stiffness = Spring.StiffnessLow),
        label = "backgroundColor"
    )

    val iconColor by animateColorAsState(
        targetValue = if (dismissState.dismissDirection == SwipeToDismissBoxValue.EndToStart)
            AppTheme.colors.milkyWhite else AppTheme.colors.transparent,
        animationSpec = spring(stiffness = Spring.StiffnessLow),
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