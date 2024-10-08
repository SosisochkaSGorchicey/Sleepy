package com.core.sleepy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.media3.common.MediaItem
import androidx.media3.common.util.UnstableApi
import androidx.media3.common.util.Util
import androidx.media3.exoplayer.ExoPlayer
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.core.common.navigation.SharedScreen
import com.core.common.navigation.screen
import com.core.ui.theme.AppTheme

class MainActivity : ComponentActivity() {

    private var player: ExoPlayer? = null
    private var playWhenReady = true
    private var mediaItemIndex = 0
    private var playbackPosition = 0L


    private fun initializePlayer() {
        player = ExoPlayer.Builder(this)
            .build()
            .also { exoPlayer ->
                val mediaItem =
                    MediaItem.fromUri("https://storage.googleapis.com/exoplayer-test-media-0/play.mp3")
                exoPlayer.setMediaItem(mediaItem)

                exoPlayer.setMediaItems(listOf(mediaItem), mediaItemIndex, playbackPosition)
                exoPlayer.playWhenReady = playWhenReady


                exoPlayer.prepare()
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //initializePlayer()

        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(scrim = 0),
            navigationBarStyle = SystemBarStyle.dark(scrim = 0)
        )
        setContent {
            AppTheme {
//                Button(onClick = {
//                    this.startActivity(Intent(this, PlayerActivity::class.java))
//                }) {
//                    Text(text = "Go to second activity")
//                }

//                Row {
//
//                    Icon(
//                        modifier = Modifier.clickable {
//                            player?.play()
//                        },
//                        imageVector = Icons.Rounded.PlayArrow,
//                        contentDescription = null
//                    )
//
//                    Icon(
//                        modifier = Modifier.clickable {
//                            player?.pause()
//                        },
//                        imageVector = Icons.Rounded.Close,
//                        contentDescription = null
//                    )
//                }


                val loadingScreen = rememberScreen(provider = SharedScreen.Splash)
                Navigator(screen = loadingScreen) {
                    SlideTransition(navigator = it)
                }
            }
        }
    }

    @UnstableApi
    public override fun onStart() {
        super.onStart()
        if (Util.SDK_INT > 23) {
            //initializePlayer()
        }
    }

    @UnstableApi
    public override fun onResume() {
        super.onResume()
        //hideSystemUi()
        if ((Util.SDK_INT <= 23 || player == null)) {
            //initializePlayer()
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

    private fun releasePlayer() {
        player?.let { exoPlayer ->
            playbackPosition = exoPlayer.currentPosition
            mediaItemIndex = exoPlayer.currentMediaItemIndex
            playWhenReady = exoPlayer.playWhenReady
            exoPlayer.release()
        }
        player = null
    }

//    @SuppressLint("InlinedApi")
//    private fun hideSystemUi() {
//        WindowCompat.setDecorFitsSystemWindows(window, false)
//        WindowInsetsControllerCompat(window, viewBinding.videoView).let { controller ->
//            controller.hide(WindowInsetsCompat.Type.systemBars())
//            controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
//        }
//    }

}