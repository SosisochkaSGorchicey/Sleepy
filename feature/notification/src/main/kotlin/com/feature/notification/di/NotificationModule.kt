package com.feature.notification.di

import cafe.adriel.voyager.core.registry.screenModule
import com.core.common.navigation.SharedScreen
import com.feature.notification.presentation.NotificationScreen
import com.feature.notification.presentation.screenmodel.NotificationScreenModel
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val notificationScreenModule = screenModule {
    register<SharedScreen.NotificationsRoute> {
        NotificationScreen
    }
}

val notificationFeatureModule = module {
    factoryOf(::NotificationScreenModel)
}