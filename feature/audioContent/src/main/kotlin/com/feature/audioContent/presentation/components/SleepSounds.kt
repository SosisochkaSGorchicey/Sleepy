package com.feature.audioContent.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.core.ui.R
import com.core.ui.theme.AppTheme

@Composable
fun SleepSounds() {
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = stringResource(id = R.string.sleep_sounds_section_title),
            style = AppTheme.typography.bodyMediumBold
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(AppTheme.shapes.smallCornersDp)
                .background(AppTheme.colors.blueToBlueGradientVertical)
                .padding(20.dp)
        ) {
            Image(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .fillMaxWidth(.3f),
                painter = painterResource(id = R.drawable.flower_dark_face),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )

            Image(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .fillMaxWidth(.1f),
                painter = painterResource(id = R.drawable.flower_light_face),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )

            Column(
                modifier = Modifier.fillMaxWidth(.6f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "GH cdshjihds ikk",
                    style = AppTheme.typography.bodyMediumBold,
                    color = AppTheme.colors.milkyWhite
                )
            }
        }
    }
}