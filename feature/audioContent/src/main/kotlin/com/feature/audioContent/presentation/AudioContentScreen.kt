package com.feature.audioContent.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import com.core.ui.theme.AppTheme
import com.core.ui.uiElements.mainScreenElements.MainBottomBar
import com.feature.audioContent.presentation.components.AudioContentScreenUI
import com.feature.audioContent.presentation.screenmodel.AudioContentScreenModel
import org.orbitmvi.orbit.compose.collectAsState

object AudioContentScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel = getScreenModel<AudioContentScreenModel>()
        val state = viewModel.collectAsState().value

        val context = LocalContext.current

        Scaffold(
            bottomBar = {
                MainBottomBar()
            },
            containerColor = AppTheme.colors.lightPeachy,
            contentColor = AppTheme.colors.baseBlue
        ) {

            AudioContentScreenUI(
                modifier = Modifier.padding(it),
                state = state
            )
//            Box(
//                modifier = Modifier
//                    .padding(it)
//                    .fillMaxSize(),
//                contentAlignment = Alignment.Center
//            ) {
//                Button(onClick = {
//                    context.startActivity(Intent(context, PlayerActivity::class.java))
//                }) {
//                    Text(text = "Go to player")
//                }
//            }
        }
    }
}