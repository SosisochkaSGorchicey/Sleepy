package com.feature.player.di

import androidx.media3.common.AudioAttributes
import androidx.media3.common.C
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector
import androidx.media3.session.MediaSession
import cafe.adriel.voyager.core.registry.screenModule
import com.core.common.navigation.SharedScreen
import com.feature.player.presentation.detailes.DetailsScreen
import com.feature.player.presentation.detailes.screenmodel.PlayerDetailsScreenModel
import com.feature.player.service.MusicServiceHandler
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

@UnstableApi
val playerModule = module {
    factoryOf(::PlayerDetailsScreenModel)
    singleOf(::MusicServiceHandler)

    factory<MediaSession> {
        MediaSession.Builder(get(), get()).build()
    }

    single<AudioAttributes> {
        AudioAttributes.Builder()
            .setContentType(C.AUDIO_CONTENT_TYPE_MUSIC)
            .setUsage(C.USAGE_MEDIA)
            .build()
    }

    single<Player> {
        ExoPlayer.Builder(get())
            .setAudioAttributes(get(), true)
            .setHandleAudioBecomingNoisy(true)
            .setTrackSelector(DefaultTrackSelector(get()))
            .build()
    }
}

val playerScreenModule = screenModule {
    register<SharedScreen.PlayerDetailScreen> {
        DetailsScreen(it.url)
    }
}