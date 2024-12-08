package com.feature.notification.di

import cafe.adriel.voyager.core.registry.screenModule
import com.core.common.navigation.SharedScreen
import com.feature.notification.presentation.add.screenmodel.AddNotificationScreenModel
import com.feature.notification.presentation.main.NotificationScreen
import com.feature.notification.presentation.main.screenmodel.NotificationScreenModel
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val notificationScreenModule = screenModule {
    register<SharedScreen.NotificationsRoute> {
        NotificationScreen
    }
}

val notificationFeatureModule = module {
    factoryOf(::NotificationScreenModel)
    factoryOf(::AddNotificationScreenModel)
}