package com.feature.auth.signUp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.alice.ui.theme.AppTheme
import com.alice.ui.uiElements.RoundedTextField
import com.core.ui.R

@Composable
fun SignUpCard() {
    Column(
        modifier = Modifier
            .padding(horizontal = 24.dp, vertical = 32.dp)
            .fillMaxSize()
            .clip(AppTheme.shapes.mediumCornersDp)
            .background(AppTheme.colors.lightPeachy)
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header()

        RoundedTextField(
            modifier = Modifier.fillMaxWidth(),
            currentText = "",
            placeholderText = stringResource(id = R.string.name_placeholder),
            onValueChange = { },
            errorTextRes = null
        )

        RoundedTextField(
            modifier = Modifier.fillMaxWidth(),
            currentText = "",
            placeholderText = stringResource(id = R.string.email_placeholder),
            onValueChange = { },
            errorTextRes = R.string.sign_in, //todo
            keyboardType = KeyboardType.Email
        )

        RoundedTextField(
            modifier = Modifier.fillMaxWidth(),
            currentText = "",
            placeholderText = stringResource(id = R.string.password_placeholder),
            onValueChange = { },
            errorTextRes = null,
            keyboardType = KeyboardType.Password,
            visualTransformation = PasswordVisualTransformation(mask = '\u25CF'),
        )
    }
}

@Composable
private fun Header() {
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = stringResource(id = R.string.sign_up_header),
        color = AppTheme.colors.baseBlue,
        style = AppTheme.typography.headlineMedium.copy(textAlign = TextAlign.Center)
    )
}