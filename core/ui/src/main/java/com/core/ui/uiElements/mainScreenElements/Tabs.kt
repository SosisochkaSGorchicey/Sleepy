package com.core.ui.uiElements.mainScreenElements

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.core.common.navigation.SharedScreen
import com.core.common.navigation.screen
import com.core.ui.R

enum class Tabs(
    val imageRes: Int,
    val tab: Tab
) {
    Content(
        imageRes = R.drawable.balance,
        tab = ContentTab
    ),
    Home(
        imageRes = R.drawable.flower_dark_face_small,
        tab = HomeTab
    ),
    Notification(
        imageRes = R.drawable.bell,
        tab = NotificationTab
    )
}

object ContentTab : Tab {
    override val key: ScreenKey = Tabs.Content.name

    @Composable
    override fun Content() {
        Navigator(SharedScreen.ContentRoute.screen())
    }

    override val options: TabOptions
        @Composable
        get() {
            return remember {
                TabOptions(index = 0u, title = "")
            }
        }
}

object HomeTab : Tab {
    override val key: ScreenKey = Tabs.Home.name

    @Composable
    override fun Content() {
        Navigator(SharedScreen.HomeRoute.screen())
    }

    override val options: TabOptions
        @Composable
        get() {
            return remember {
                TabOptions(index = 1u, title = "")
            }
        }
}

object NotificationTab : Tab {
    override val key: ScreenKey = Tabs.Notification.name

    @Composable
    override fun Content() {
        Navigator(SharedScreen.NotificationsRoute.screen())
    }

    override val options: TabOptions
        @Composable
        get() {
            return remember {
                TabOptions(index = 2u, title = "")
            }
        }
}
