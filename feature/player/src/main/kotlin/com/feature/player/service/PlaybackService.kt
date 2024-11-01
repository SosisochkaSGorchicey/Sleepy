package com.feature.player.service

import android.content.Intent
import android.os.Build
import androidx.media3.common.AudioAttributes
import androidx.media3.common.C
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.session.MediaSession
import androidx.media3.session.MediaSessionService
import com.google.common.util.concurrent.Futures
import com.google.common.util.concurrent.ListenableFuture
import org.koin.android.ext.android.inject

class PlaybackService : MediaSessionService(), MediaSession.Callback {
    private val mediaSession: MediaSession by inject<MediaSession>()

    @UnstableApi
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        println("TAG: PlaybackService onStartCommand")
        println("TAG: PlaybackService intent $intent")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            musicNotificationManager.startMusicNotificationService(
//                mediaSession = mediaSession,
//                mediaSessionService = this
//            ) todo
        }
        return super.onStartCommand(intent, flags, startId)
    }


    override fun onTaskRemoved(rootIntent: Intent?) {
        println("TAG: SERVICE onTaskRemoved")
        stopSelf()
    }

    override fun onGetSession(controllerInfo: MediaSession.ControllerInfo): MediaSession =
        mediaSession

    override fun onDestroy() {
        println("TAG: SERVICE onDestroy")
        super.onDestroy()
        mediaSession.apply {
            release()
            player.release()
        }
        super.onDestroy()
    }
}