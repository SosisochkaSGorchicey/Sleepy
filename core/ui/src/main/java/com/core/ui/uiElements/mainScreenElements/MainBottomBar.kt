package com.core.ui.uiElements.mainScreenElements

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import com.core.ui.theme.AppTheme

@Composable
fun MainBottomBar() {
    NavigationBar(
        modifier = Modifier.clip(AppTheme.shapes.topCorners),
        containerColor = AppTheme.colors.baseBlue,
        contentColor = AppTheme.colors.white
    ) {
        Tabs.entries.forEach {
            TabNavigationItem(it.tab)
        }
    }
}

@Composable
fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current
    val isSelected = tabNavigator.current == tab
    val imageRes = Tabs.valueOf(tab.key).imageRes

    NavigationBarItem(
        selected = isSelected,
        alwaysShowLabel = false,
        onClick = { tabNavigator.current = tab },
        icon = {
            Image(
                modifier = Modifier
                    .clip(AppTheme.shapes.rounded)
                    .size(44.dp)
                    .background(AppTheme.colors.baseBlueLight)
                    .border(
                        width = 3.dp,
                        color = if (isSelected) AppTheme.colors.basePeachy else AppTheme.colors.transparent,
                        shape = AppTheme.shapes.rounded
                    )
                    .padding(8.dp),
                painter = painterResource(id = imageRes),
                contentDescription = null
            )
        },
        colors = NavigationBarItemDefaults.colors(
            indicatorColor = AppTheme.colors.transparent,
            selectedIconColor = AppTheme.colors.white,
            unselectedIconColor = AppTheme.colors.white
        )
    )
}