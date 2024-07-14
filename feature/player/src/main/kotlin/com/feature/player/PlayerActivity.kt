package com.feature.player

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.Timeline
import androidx.media3.common.util.UnstableApi
import androidx.media3.common.util.Util
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.alice.ui.theme.SleepyTheme

class PlayerActivity : ComponentActivity() {

    private var myplayer: ExoPlayer? = null
    private var playWhenReady = false
    private var mediaItemIndex = 0
    private var playbackPosition = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializePlayer()

        enableEdgeToEdge()
        setContent {
            SleepyTheme {
                Scaffold {


                    AndroidView(
                        modifier = Modifier.padding(it),
                        factory = {
                        PlayerView(this).apply {
                            player = myplayer
                        }
                    }
                    )

//
//                    Row(
//                        modifier = Modifier
//                            .padding(it)
//                            .fillMaxSize(),
//                        verticalAlignment = Alignment.CenterVertically,
//                        horizontalArrangement = Arrangement.spacedBy(
//                            20.dp,
//                            Alignment.CenterHorizontally
//                        )
//                    ) {
//                        IconButton(
//                            onClick = {}
//                        ) {
//                            Icon(
//                                imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowLeft,
//                                contentDescription = null
//                            )
//                        }
//
//                        IconButton(
//                            onClick = {
//                                player?.playWhenReady = true
//                                //player?.play()
//                            }
//                        ) {
//                            Icon(
//                                imageVector = Icons.Rounded.PlayArrow,
//                                contentDescription = null
//                            )
//                        }
//
//                        IconButton(
//                            onClick = {
//                                player?.playWhenReady = false
//                            }
//                        ) {
//                            Icon(
//                                imageVector = Icons.Rounded.Clear,
//                                contentDescription = null
//                            )
//                        }
//
//                        IconButton(
//                            onClick = {}
//                        ) {
//                            Icon(
//                                imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowRight,
//                                contentDescription = null
//                            )
//                        }
//
//                        Text(text = player?.currentMediaItemIndex.toString())
//                    }
                }
            }
        }
    }


    @UnstableApi
    public override fun onStart() {
        super.onStart()
        if (Util.SDK_INT > 23) {
            initializePlayer()
        }
    }

    @UnstableApi
    public override fun onResume() {
        super.onResume()
        if ((Util.SDK_INT <= 23 || myplayer == null)) {
            initializePlayer()
        }
    }

    @UnstableApi
    public override fun onPause() {
        super.onPause()
        if (Util.SDK_INT <= 23) {
            releasePlayer()
        }
    }

    @UnstableApi
    public override fun onStop() {
        super.onStop()
        if (Util.SDK_INT > 23) {
            releasePlayer()
        }
    }

    private fun initializePlayer() {
        myplayer = ExoPlayer.Builder(this)
            .build()
            .also { exoPlayer ->
                val mediaItem =
                    MediaItem.fromUri("https://storage.googleapis.com/exoplayer-test-media-0/play.mp3")
                exoPlayer.setMediaItem(mediaItem)

                exoPlayer.setMediaItems(listOf(mediaItem), mediaItemIndex, playbackPosition)
                exoPlayer.playWhenReady = playWhenReady
                exoPlayer.prepare()

                exoPlayer.addListener(
                    object : Player.Listener {
                        override fun onTimelineChanged(timeline: Timeline, reason: Int) {
                            super.onTimelineChanged(timeline, reason)
                            println("TAG:reason $reason periodCount ${timeline.periodCount}")
                        }


                    }
                )
            }
    }

    private fun releasePlayer() {
        myplayer?.let { exoPlayer ->
            playbackPosition = exoPlayer.currentPosition
            mediaItemIndex = exoPlayer.currentMediaItemIndex
            playWhenReady = exoPlayer.playWhenReady
            exoPlayer.release()
        }
        myplayer = null
    }
}
