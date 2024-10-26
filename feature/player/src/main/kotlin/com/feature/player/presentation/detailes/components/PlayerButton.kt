package com.feature.player.presentation.detailes.components

import Stop
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.core.ui.R
import com.core.ui.theme.AppTheme

@Composable
fun PlayerButton(
    onPlayStop: () -> Unit,
    onSelect: () -> Unit
) {
    val isSelected = rememberSaveable{ //todo
        mutableStateOf(false)
    }

    Button(
        onClick = {
            if (isSelected.value) {
                onPlayStop()
            } else {
                isSelected.value = !isSelected.value
                onSelect()
            }
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = AppTheme.colors.baseBlue,
            contentColor = AppTheme.colors.milkyWhite
        ),
        shape = AppTheme.shapes.mediumCornersPercent
    ) {
        Text(
            text = "PlayStop",
//            if (isPlaying.value) stringResource(R.string.stop_button) todo
//            else stringResource(R.string.play_button),
            style = AppTheme.typography.bodyMediumBold
        )

        Icon(
            modifier = Modifier.size(28.dp),
            imageVector = Icons.Default.PlayArrow,
            //if (isPlaying.value) Stop else Icons.Default.PlayArrow, todo
            contentDescription = null
        )
    }
}