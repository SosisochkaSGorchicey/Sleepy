package com.feature.notification.presentation.add.components

import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.core.ui.theme.AppTheme

@Composable
fun SectionTitle(
    @StringRes textRes: Int,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = stringResource(textRes),
        style = AppTheme.typography.bodyMediumBold
    )
}

@Composable
fun SectionTitleWithHint(
    @StringRes textRes: Int,
    onClick: () -> Unit,
    @StringRes hintTextRes: Int,
    visible: Boolean
) {
    val animatedColor by animateColorAsState(
        if (visible) AppTheme.colors.baseBlueLight else AppTheme.colors.transparent,
        label = "animatedColor"
    )

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(textRes),
            style = AppTheme.typography.bodyMediumBold
        )

        Row(
            modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.End)
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = stringResource(hintTextRes),
                style = AppTheme.typography.bodySuperSmall,
                color = animatedColor,
                textAlign = TextAlign.End,
                minLines = 2,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Icon(
                modifier = Modifier
                    .clip(AppTheme.shapes.rounded)
                    .clickable(onClick = onClick)
                    .padding(4.dp),
                imageVector = Icons.Outlined.Info,
                contentDescription = null
            )
        }
    }
}