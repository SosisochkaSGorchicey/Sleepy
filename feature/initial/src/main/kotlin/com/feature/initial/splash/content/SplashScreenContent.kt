package com.feature.initial.splash.content

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.alice.ui.theme.AppTheme
import com.core.ui.R


@Composable
fun SplashScreenContent(
    modifier: Modifier
) {
    val textModifier: Modifier = Modifier.padding(top = 32.dp)

    BackgroundUI()

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Text(
            modifier = textModifier
                .scale(getScaleTextAnimation()),
            text = stringResource(id = R.string.sleepy),
            style = AppTheme.typography.headlineLarge,
            color = AppTheme.colors.milkyWhite
        )
    }
}