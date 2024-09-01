package com.feature.notification.di

import cafe.adriel.voyager.core.registry.screenModule
import com.core.common.navigation.SharedScreen
import com.feature.notification.presentation.NotificationScreen

val notificationScreenModule = screenModule {
    register<SharedScreen.NotificationsRoute> {
        NotificationScreen
    }
}