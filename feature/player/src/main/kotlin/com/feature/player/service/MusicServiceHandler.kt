package com.feature.player.service

import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import com.feature.player.utils.MediaStateEvents
import com.feature.player.utils.MusicStates
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MusicServiceHandler(
    private val exoPlayer: Player,
) : Player.Listener {

    private val _musicStates: MutableStateFlow<MusicStates> = MutableStateFlow(MusicStates.Initial)
    val musicStates: StateFlow<MusicStates> = _musicStates.asStateFlow()

    private var job: Job? = null

    init {
        runCatching {
            exoPlayer.addListener(this)
        }
    }

    fun setMediaItem(mediaItem: MediaItem) {
        runCatching {
            exoPlayer.setMediaItem(mediaItem)
            exoPlayer.prepare()
        }
    }

    suspend fun onMediaStateEvents(
        mediaStateEvents: MediaStateEvents,
        selectedMusicIndex: Int = -1,
        seekPosition: Long = 0,
    ) {
        withContext(Dispatchers.Main) {
            println("TAG: onMediaStateEvents $mediaStateEvents")
            when (mediaStateEvents) {
                MediaStateEvents.Backward -> exoPlayer.seekBack()
                MediaStateEvents.Forward -> exoPlayer.seekForward()
                MediaStateEvents.PlayPause -> playPauseMusic()
                MediaStateEvents.SeekTo -> exoPlayer.seekTo(seekPosition)
                MediaStateEvents.Stop -> stopProgressUpdate()
                is MediaStateEvents.SelectedMusicChange -> { //todo catch network error
                   // try {


                        when (selectedMusicIndex) {
                            exoPlayer.currentMediaItemIndex -> {
                                playPauseMusic()
                            }

                            else -> {
                                println("TAG: exoPlayer.applicationLooper ${exoPlayer.applicationLooper.isCurrentThread}")
                                exoPlayer.setMediaItem(
                                    MediaItem.fromUri(mediaStateEvents.url)
                                )
                                exoPlayer.seekToDefaultPosition(selectedMusicIndex)
                                _musicStates.value = MusicStates.MediaPlaying(
                                    isPlaying = true
                                )
                                exoPlayer.playWhenReady = true
                                startProgressUpdate()
                            }
                        }
//                    } catch (e: Throwable) {
//                        println("TAG: in catch e $e")
//                    }
                }

                is MediaStateEvents.MediaProgress -> {
                    exoPlayer.seekTo(
                        (exoPlayer.duration * mediaStateEvents.progress).toLong()
                    )
                }
            }
        }
    }

    override fun onPlaybackStateChanged(playbackState: Int) {
        println("TAG: playbackState $playbackState")
        when (playbackState) {

            ExoPlayer.STATE_BUFFERING -> _musicStates.value =
                MusicStates.MediaBuffering(exoPlayer.currentPosition)

            ExoPlayer.STATE_READY -> _musicStates.value = MusicStates.MediaReady(exoPlayer.duration)

            Player.STATE_ENDED -> {
                // no-op
            }

            Player.STATE_IDLE -> {
                exoPlayer.prepare()
                // no-op
            }
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun onIsPlayingChanged(isPlaying: Boolean) {
        _musicStates.value = MusicStates.MediaPlaying(isPlaying = isPlaying)
        if (isPlaying) {
            GlobalScope.launch(Dispatchers.Main) {
                startProgressUpdate()
            }
        } else {
            stopProgressUpdate()
        }
    }

    private suspend fun playPauseMusic() {
        if (exoPlayer.isPlaying) {
            exoPlayer.pause()
            stopProgressUpdate()
        } else {
            exoPlayer.play()
            _musicStates.value = MusicStates.MediaPlaying(
                isPlaying = true
            )
            startProgressUpdate()
        }
    }

    private suspend fun startProgressUpdate() = job.run {
        while (true) {
            delay(500)
            _musicStates.value = MusicStates.MediaProgress(exoPlayer.currentPosition)
        }
    }

    private fun stopProgressUpdate() {
        job?.cancel()
        _musicStates.value = MusicStates.MediaPlaying(isPlaying = false)
    }
}