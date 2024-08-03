package com.feature.initial.splash

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.alice.common.navigation.SharedScreen
import com.alice.common.navigation.screen
import com.feature.initial.splash.content.SplashScreenContent
import com.feature.initial.splash.screenmodel.SplashScreenModel
import com.feature.initial.splash.screenmodel.SplashSideEffect
import org.orbitmvi.orbit.compose.collectSideEffect


class SplashScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel = getScreenModel<SplashScreenModel>()

        Scaffold { padding ->
            SplashScreenContent(
                modifier = Modifier.padding(padding)
            )
        }

        viewModel.collectSideEffect { sideEffect ->
            when (sideEffect) {
                SplashSideEffect.NavigateToAuth -> navigator.replace(
                    SharedScreen.SighIn.screen()
                )

                SplashSideEffect.NavigateToHome -> navigator.replace(
                    SharedScreen.Home.screen()
                )
            }
        }
    }
}