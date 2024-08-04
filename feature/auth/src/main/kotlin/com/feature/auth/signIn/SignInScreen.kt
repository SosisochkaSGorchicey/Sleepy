package com.feature.auth.signIn

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import com.alice.ui.theme.AppTheme
import com.feature.auth.signIn.components.SignInScreenUI

object SignInScreen : Screen {
    @Composable
    override fun Content() {
        Scaffold(
            containerColor = AppTheme.colors.baseBlue
        ) {
            SignInScreenUI(
                modifier = Modifier.padding(top = it.calculateTopPadding()),
                bottomSheetModifier = Modifier.padding(bottom = it.calculateBottomPadding())
            )
        }
    }
}