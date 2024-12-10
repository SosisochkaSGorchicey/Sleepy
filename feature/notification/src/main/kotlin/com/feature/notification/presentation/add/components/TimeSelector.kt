package com.feature.notification.presentation.add.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TimeInput
import androidx.compose.material3.TimePickerColors
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow
import com.core.ui.theme.AppTheme
import dev.darkokoa.datetimewheelpicker.WheelTimePicker

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColumnScope.TimeSelector() {
    WheelTimePicker { snappedTime -> }

//    val timePickerState = rememberTimePickerState(
//        is24Hour = true,
//
//        )
//
//    TimeInput(
//        modifier = Modifier.align(Alignment.CenterHorizontally),
//        state = timePickerState,
//        colors = TimePickerColors(
//            clockDialColor = Red,
//            selectorColor = Green,
//            containerColor = Black,
//            periodSelectorBorderColor = Green,
//            clockDialSelectedContentColor = Yellow,
//            clockDialUnselectedContentColor = Color.Cyan,
//            periodSelectorSelectedContainerColor = Blue,
//            periodSelectorSelectedContentColor = White,
//            periodSelectorUnselectedContainerColor = Color.Magenta,
//            periodSelectorUnselectedContentColor = Green,
//            timeSelectorSelectedContainerColor = AppTheme.colors.milkyWhite,
//            timeSelectorSelectedContentColor = AppTheme.colors.baseBlue,
//            timeSelectorUnselectedContainerColor = AppTheme.colors.baseBlueLight,
//            timeSelectorUnselectedContentColor = AppTheme.colors.baseGray
//        )
//    )
}