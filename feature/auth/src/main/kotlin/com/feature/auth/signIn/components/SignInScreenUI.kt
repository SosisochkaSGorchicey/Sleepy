package com.feature.auth.signIn.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.feature.auth.signIn.screenmodel.SignInEvent
import com.feature.auth.signIn.screenmodel.SignInState

@Composable
fun SignInScreenUI(
    modifier: Modifier,
    bottomSheetModifier: Modifier,
    state: SignInState,
    onEvent: (SignInEvent) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LogInCard(
            bottomSheetModifier = bottomSheetModifier,
            state = state,
            onEvent = onEvent
        )
    }
}