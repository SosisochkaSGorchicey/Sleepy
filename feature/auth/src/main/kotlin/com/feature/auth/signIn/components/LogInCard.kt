package com.feature.auth.signIn.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.alice.ui.theme.AppTheme
import com.alice.ui.uiElements.MainButton
import com.alice.ui.uiElements.RoundedTextField
import com.core.ui.R
import com.feature.auth.signIn.screenmodel.SignInEvent
import com.feature.auth.signIn.screenmodel.SignInState

@Composable
fun LogInCard(
    bottomSheetModifier: Modifier,
    state: SignInState,
    onEvent: (SignInEvent) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(AppTheme.shapes.topForm)
                .background(AppTheme.colors.lightPeachy)
                .border(
                    width = 4.dp,
                    color = AppTheme.colors.basePeachy,
                    shape = AppTheme.shapes.topForm
                )
                .verticalScroll(rememberScrollState())
                .then(bottomSheetModifier)
                .padding(horizontal = 24.dp, vertical = 32.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.Start
        ) {
            LogInHeader()

            RoundedTextField(
                modifier = Modifier.fillMaxWidth(.8f),
                currentText = state.logInData.email.first,
                placeholderText = stringResource(id = R.string.email_placeholder),
                onValueChange = { onEvent(SignInEvent.OnEmailChange(newValue = it)) },
                errorTextRes = state.logInData.email.second,
                keyboardType = KeyboardType.Email
            )

            RoundedTextField(
                modifier = Modifier.fillMaxWidth(.8f),
                currentText = state.logInData.password.first,
                placeholderText = stringResource(id = R.string.password_placeholder),
                onValueChange = { onEvent(SignInEvent.OnPasswordChange(newValue = it)) },
                errorTextRes = state.logInData.password.second,
                keyboardType = KeyboardType.Password,
                visualTransformation = PasswordVisualTransformation(mask = '\u25CF'),
            )

            MainButton(
                modifier = Modifier.fillMaxWidth(.8f),
                onClick = { onEvent(SignInEvent.OnSignInClick) },
                text = stringResource(id = R.string.sign_in),
                containerColor = AppTheme.colors.baseBlue,
                borderColor = AppTheme.colors.baseBlueLight
            )

            OtherAuthActionsDisplay(
                onEvent = onEvent
            )
        }

        LogInImage()
    }
}

@Composable
private fun BoxScope.LogInImage() {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

    Image(
        modifier = Modifier
            .offset(y = -(screenWidth / 8))
            .align(Alignment.TopEnd)
            .width(screenWidth / 3)
            .rotate(25f),
        painter = painterResource(id = R.drawable.flower_dark_face),
        contentDescription = null,
        contentScale = ContentScale.FillWidth
    )
}

@Composable
private fun LogInHeader() {
    Text(
        modifier = Modifier.fillMaxWidth(.6f),
        text = stringResource(id = R.string.log_in_header),
        color = AppTheme.colors.baseBlue,
        style = AppTheme.typography.headlineMedium
    )
}