package com.feature.player

import android.content.ComponentName
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.media3.common.MediaMetadata
import androidx.media3.common.PlaybackException
import androidx.media3.common.Player
import androidx.media3.common.Player.COMMAND_PLAY_PAUSE
import androidx.media3.common.Player.COMMAND_PREPARE
import androidx.media3.common.Player.COMMAND_SET_MEDIA_ITEM
import androidx.media3.common.Timeline
import androidx.media3.session.MediaController
import androidx.media3.session.SessionToken
import com.core.ui.theme.AppTheme
import com.feature.player.presentation.detailes.DetailsScreenUI
import com.google.common.util.concurrent.ListenableFuture
import com.google.common.util.concurrent.MoreExecutors


class PlayerActivity : ComponentActivity() {
    private lateinit var controllerFuture: ListenableFuture<MediaController>
    private lateinit var controller: MediaController

    override fun onDestroy() {
        super.onDestroy()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(scrim = 0),
            navigationBarStyle = SystemBarStyle.dark(scrim = 0)
        )

        setContent {
            AppTheme {
                DetailsScreenUI()
            }

//            AndroidView(factory = { context ->
//
//                PlayerView(context).apply {
//                    player =
//                }
//            })
//
//            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
//                Button(onClick = {
//                    val url = "https://download.samplelib.com/mp3/sample-15s.mp3"
//                    val mediaItem = MediaItem.Builder().setMediaId(url).build()
//
//                    controller.setMediaItem(mediaItem)
//                    play()
//
//
//                    println("TAG: TEST ${controller.availableSessionCommands.commands}")
//
//
//                    // controller.play()
//                }) {
//                    Text(text = "Play")
//                }
//            }
        }
    }

    override fun onStart() {
        super.onStart()
        val sessionToken = SessionToken(this, ComponentName(this, PlaybackService::class.java))
        controllerFuture = MediaController.Builder(this, sessionToken).buildAsync()
        controllerFuture.addListener(
            {
                controller = controllerFuture.get()
                initController()
            },
            MoreExecutors.directExecutor()
        )
    }

    override fun onStop() {
        super.onStop()

        MediaController.releaseFuture(controllerFuture)

    }

    private fun initController() {
        //controller.playWhenReady = true
        controller.addListener(object : Player.Listener {

            override fun onMediaMetadataChanged(mediaMetadata: MediaMetadata) {
                super.onMediaMetadataChanged(mediaMetadata)
                //log("onMediaMetadataChanged=$mediaMetadata")
            }

            override fun onIsPlayingChanged(isPlaying: Boolean) {
                super.onIsPlayingChanged(isPlaying)
                //log("onIsPlayingChanged=$isPlaying")
            }

            override fun onPlaybackStateChanged(playbackState: Int) {
                super.onPlaybackStateChanged(playbackState)
                log("onPlaybackStateChanged=${getStateName(playbackState)}")
            }

            override fun onPlayerError(error: PlaybackException) {
                super.onPlayerError(error)
                log("onPlayerError=${error.stackTraceToString()}")
            }

            override fun onPlayerErrorChanged(error: PlaybackException?) {
                super.onPlayerErrorChanged(error)
                log("onPlayerErrorChanged=${error?.stackTraceToString()}")
            }

            override fun onTimelineChanged(timeline: Timeline, reason: Int) {
                println("TAG: timeline $timeline")
                println("TAG: reason $reason")
                super.onTimelineChanged(timeline, reason)
            }
        })
        log("start=${getStateName(controller.playbackState)}")
        log("COMMAND_PREPARE=${controller.isCommandAvailable(COMMAND_PREPARE)}")
        log("COMMAND_SET_MEDIA_ITEM=${controller.isCommandAvailable(COMMAND_SET_MEDIA_ITEM)}")
        log("COMMAND_PLAY_PAUSE=${controller.isCommandAvailable(COMMAND_PLAY_PAUSE)}")
    }

    private fun play() {
        //log("before=${getStateName(controller.playbackState)}")


        // controller.playWhenReady = true
        controller.prepare()
        controller.play()
        //log("after=${getStateName(controller.playbackState)}")
    }

    private fun getStateName(i: Int): String? {
        return when (i) {
            1 -> "STATE_IDLE"
            2 -> "STATE_BUFFERING"
            3 -> "STATE_READY"
            4 -> "STATE_ENDED"
            else -> null
        }
    }

    private fun log(message: String) {
        Log.e("TAG", message)
    }
}
