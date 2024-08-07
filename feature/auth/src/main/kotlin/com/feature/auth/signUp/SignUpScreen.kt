package com.feature.auth.signUp

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import com.alice.ui.theme.AppTheme
import com.feature.auth.signUp.components.SignUpScreenUI

object SignUpScreen : Screen {
    @Composable
    override fun Content() {
        Scaffold(
            containerColor = AppTheme.colors.baseBlue
        ) {
            SignUpScreenUI(outerModifier = Modifier.padding(it))
        }
    }
}