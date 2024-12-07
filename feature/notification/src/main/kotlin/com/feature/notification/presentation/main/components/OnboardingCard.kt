package com.feature.notification.presentation.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.core.ui.R
import com.core.ui.theme.AppTheme
import com.core.ui.uiElements.MainButton

@Composable
fun OnboardingCard(
    modifier: Modifier,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .padding(24.dp)
            .fillMaxSize()
            .clip(AppTheme.shapes.mediumCornersDp)
            .background(AppTheme.colors.baseBlueLight)
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.notif_onboarding_card_title),
            color = AppTheme.colors.white,
            style = AppTheme.typography.bodyMediumBold.copy(
                textAlign = TextAlign.Center
            )
        )

        MainButton(
            modifier = Modifier,
            onClick = onClick,
            text = stringResource(R.string.button_lets_go),
            containerColor = AppTheme.colors.lightPeachy,
            contentColor = AppTheme.colors.baseBlue,
            borderColor = AppTheme.colors.basePeachy
        )
    }
}