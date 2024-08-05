package com.feature.auth.signIn.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.alice.ui.theme.AppTheme
import com.alice.ui.uiElements.MainButton
import com.core.ui.R

@Composable
fun OtherAuthActionsDisplay() {
    Column(
        modifier = Modifier
            .padding(vertical = 40.dp, horizontal = 10.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DividerElement()

        MainButton(
            onClick = {},
            text = stringResource(id = R.string.anonymous_sign_in)
        )

        MainButton(
            onClick = {},
            text = stringResource(id = R.string.no_account_text),
            containerColor = AppTheme.colors.baseBlue,
            borderColor = AppTheme.colors.baseBlueLight,
            addImages = true
        )
    }
}

@Composable
private fun RowScope.Divider() {
    HorizontalDivider(
        modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
        color = AppTheme.colors.baseBlueLight,
        thickness = 2.dp
    )
}

@Composable
private fun DividerElement() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally)
    ) {
        Divider()

        Text(
            text = stringResource(id = R.string.separator),
            style = AppTheme.typography.headlineSmall,
            color = AppTheme.colors.baseBlueLight
        )

        Divider()
    }
}