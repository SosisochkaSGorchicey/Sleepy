package com.feature.player.data

import android.content.Context

class Player(private val context: Context) {
    private var playWhenReady = true
    private var mediaItemIndex = 0
    private var playbackPosition = 0L
//    operator fun invoke() = ExoPlayer.Builder(context)
//        .build()
//        .also { exoPlayer ->
//            val mediaItem = MediaItem.fromUri("https://storage.googleapis.com/exoplayer-test-media-0/play.mp3")
//            exoPlayer.setMediaItem(mediaItem)
//
//            exoPlayer.setMediaItems(listOf(mediaItem), mediaItemIndex, playbackPosition)
//            exoPlayer.playWhenReady = playWhenReady
//
//
//            exoPlayer.prepare()
//        }
}