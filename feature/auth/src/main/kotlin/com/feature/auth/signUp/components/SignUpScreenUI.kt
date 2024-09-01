package com.feature.auth.signUp.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.feature.auth.signUp.screenmodel.SignUpEvent
import com.feature.auth.signUp.screenmodel.SignUpState

@Composable
fun SignUpScreenUI(
    outerModifier: Modifier = Modifier,
    state: SignUpState,
    onEvent: (SignUpEvent) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        SignUpBackground()

        Box(
            modifier = outerModifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            contentAlignment = Alignment.Center
        ) {
            SignUpCard(
                state = state,
                onEvent = onEvent
            )
        }
    }
}