package com.feature.notification.presentation.add.components

import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.core.ui.theme.AppTheme

@Composable
fun SectionTitle(@StringRes textRes: Int) {
    Text(
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
            AnimatedVisibility(
                modifier = Modifier.weight(1f),
                visible = visible
            ) {
                Text(
                    text = stringResource(hintTextRes),
                    style = AppTheme.typography.bodySuperSmall,
                    color = AppTheme.colors.baseBlueLight,
                    textAlign = TextAlign.End,
                    minLines = 2,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }

            AnimatedVisibility(visible = !visible) {
                Text(
                    text = "",
                    style = AppTheme.typography.bodySuperSmall,
                    color = AppTheme.colors.transparent,
                    textAlign = TextAlign.End,
                    minLines = 2,
                )
            }

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