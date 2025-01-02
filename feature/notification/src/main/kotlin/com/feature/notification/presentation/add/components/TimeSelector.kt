package com.feature.notification.presentation.add.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.core.ui.theme.AppTheme
import dev.darkokoa.datetimewheelpicker.WheelTimePicker
import dev.darkokoa.datetimewheelpicker.core.WheelPickerDefaults
import kotlinx.datetime.LocalTime

@Composable
fun TimeSelector(
    onTimeSelected: (LocalTime) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        WheelTimePicker(
            modifier = Modifier
                .fillMaxWidth()
                .clip(AppTheme.shapes.smallestCornersDp)
                .background(AppTheme.colors.milkyWhite.copy(alpha = .15f))
                .padding(10.dp),
            selectorProperties = WheelPickerDefaults.selectorProperties(
                shape = AppTheme.shapes.smallestCornersDp,
                color = AppTheme.colors.baseBlueLighter.copy(alpha = .4f),
                border = BorderStroke(
                    width = 1.dp,
                    color = AppTheme.colors.baseBlue
                )
            ),
            textStyle = AppTheme.typography.bodyMedium,
            textColor = AppTheme.colors.baseBlue,
            onSnappedTime = onTimeSelected
        )
    }
}