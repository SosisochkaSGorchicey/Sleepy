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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.core.ui.R
import com.core.ui.theme.AppTheme

@Composable
fun PlayerButton() {
    val isPlaying = remember {
        mutableStateOf(false)
    }

    Button(
        onClick = { isPlaying.value = !isPlaying.value },
        colors = ButtonDefaults.buttonColors(
            containerColor = AppTheme.colors.baseBlue,
            contentColor = AppTheme.colors.milkyWhite
        ),
        shape = AppTheme.shapes.mediumCornersPercent
    ) {
        Text(
            text = if (isPlaying.value) stringResource(R.string.stop_button)
            else stringResource(R.string.play_button),
            style = AppTheme.typography.bodyMediumBold
        )

        Icon(
            modifier = Modifier.size(28.dp),
            imageVector = if (isPlaying.value) Stop
            else Icons.Default.PlayArrow,
            contentDescription = null
        )
    }
}