package com.feature.player.di

import cafe.adriel.voyager.core.registry.screenModule
import com.alice.common.navigation.SharedScreen
import com.feature.player.PlayerScreen
import com.feature.player.data.Player
import com.feature.player.data.PlayerRepositoryImpl
import com.feature.player.domain.PlayerRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val playerModule = module {
    singleOf(::Player)
    singleOf(::PlayerRepositoryImpl) bind PlayerRepository::class
}

val playerScreenModule = screenModule {
    register<SharedScreen.Player> {
        PlayerScreen()
    }
}