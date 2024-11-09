package com.feature.player.presentation.detailes.screenmodel

import androidx.media3.common.MediaItem
import com.core.common.mvi.MviScreenModel
import com.core.common.mvi.emitSideEffect
import com.core.common.mvi.reducer
import com.core.domain.model.AudioDataItem
import com.core.domain.model.AudioItem
import com.feature.player.service.MusicServiceHandler
import com.feature.player.utils.MediaStateEvents
import com.feature.player.utils.MusicStates
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.withContext
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import java.util.concurrent.TimeUnit

class PlayerDetailsScreenModel(
    private val musicServiceHandler: MusicServiceHandler
) : MviScreenModel<PlayerDetailsState, PlayerDetailsSideEffect, PlayerDetailsEvent>(
    initialState = PlayerDetailsState()
) {


    init {
        intent {
            musicServiceHandler.musicStates.collectLatest { musicStates: MusicStates ->
                println("TAG: musicStates $musicStates")
                when (musicStates) {
                    MusicStates.Initial -> {
                        setMusicItems()
                        reduce { state.copy(playerDetailsUIState = PlayerDetailsUIState.InitialHome) }
                    }

                    is MusicStates.MediaBuffering -> progressCalculation(musicStates.progress)
                    is MusicStates.MediaPlaying -> reduce { state.copy(isMusicPlaying = musicStates.isPlaying) }
                    is MusicStates.MediaProgress -> progressCalculation(musicStates.progress)

                    is MusicStates.MediaReady -> reduce {
                        state.copy(
                            duration = musicStates.duration,
                            playerDetailsUIState = PlayerDetailsUIState.HomeReady
                        )
                    }

                }
            }
        }
    }

    override fun onEvent(event: PlayerDetailsEvent) { //todo разделить на функции
        when (event) {
            PlayerDetailsEvent.OnBackClick -> emitSideEffect(PlayerDetailsSideEffect.NavigateBack)
            PlayerDetailsEvent.Backward -> intent {
                musicServiceHandler.onMediaStateEvents(MediaStateEvents.Backward)
            }

            is PlayerDetailsEvent.CurrentAudioChanged -> intent {
                musicServiceHandler.onMediaStateEvents(
                    MediaStateEvents.SelectedMusicChange(state.musicItem.url),
                    selectedMusicIndex = event.index
                )
            }

            PlayerDetailsEvent.Forward -> intent {
                musicServiceHandler.onMediaStateEvents(
                    MediaStateEvents.Forward
                )
            }

            PlayerDetailsEvent.PlayPause -> intent {
                musicServiceHandler.onMediaStateEvents(
                    MediaStateEvents.PlayPause
                )
            }

            is PlayerDetailsEvent.SeekTo -> intent {
                musicServiceHandler.onMediaStateEvents(
                    MediaStateEvents.SeekTo,
                    seekPosition = ((state.duration * event.position) / 100f).toLong()
                )
            }

            is PlayerDetailsEvent.UpdateProgress -> intent {
                musicServiceHandler.onMediaStateEvents(
                    MediaStateEvents.MediaProgress(
                        event.progress
                    )
                )
                reduce { state.copy(progress = event.progress) }
            }

            is PlayerDetailsEvent.InitCurrentAudio -> initMusicItem(audioDataItem = event.audioDataItem)
        }
    }

    private fun initMusicItem(audioDataItem: AudioDataItem) {
        reducer {
            state.copy(
                musicItem = AudioItem(url = audioDataItem.audioUrl),
                currentAudioDataItem = audioDataItem
            )
        }
    }

    private fun setMusicItems() = intent {
        MediaItem.Builder()
            .setUri(state.musicItem.url)
//                .setMediaMetadata( todo
//                    MediaMetadata.Builder()
//                        .setAlbumArtist(audioItem.artist)
//                        .setDisplayTitle(audioItem.title)
//                        .setSubtitle(audioItem.displayName)
//                        .build()
//                )
            .build()
            .also {
                withContext(Dispatchers.Main) {
                    musicServiceHandler.setMediaItem(it)
                }
            }
    }

    private fun progressCalculation(currentProgress: Long) = reducer {
        state.copy(
            progress = if (currentProgress > 0) (currentProgress.toFloat() / state.duration.toFloat()) * 100f else 0f,
            progressValue = formatDurationValue(currentProgress)
        )
    }

    private fun formatDurationValue(duration: Long): String {
        val minutes = TimeUnit.MINUTES.convert(duration, TimeUnit.MILLISECONDS)
        val seconds = (minutes) - minutes * TimeUnit.SECONDS.convert(1, TimeUnit.MINUTES)

        return String.format("%02d:%02d", minutes, seconds)
    }

    override fun onDispose() {
        intent { musicServiceHandler.onMediaStateEvents(MediaStateEvents.Stop) }
        super.onDispose()
    }
}