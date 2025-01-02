package com.feature.player.presentation.detailes.screenmodel

import com.core.common.mvi.MviScreenModel
import com.core.common.mvi.emitSideEffect
import com.core.common.mvi.reducer
import com.core.domain.model.supabase.db.AudioDataItem
import com.core.domain.model.supabase.db.AudioItem
import com.feature.player.service.MusicServiceHandler
import com.feature.player.utils.MediaStateEvents
import com.feature.player.utils.MusicStates
import com.feature.player.utils.toMediaItem
import com.feature.player.utils.toProgressCalculate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.withContext
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce

class PlayerDetailsScreenModel(
    private val musicServiceHandler: MusicServiceHandler
) : MviScreenModel<PlayerDetailsState, PlayerDetailsSideEffect, PlayerDetailsEvent>(
    initialState = PlayerDetailsState()
) {

    init {
        musicStatesObserve()
    }

    override fun onEvent(event: PlayerDetailsEvent) {
        when (event) {
            PlayerDetailsEvent.OnBackClick -> emitSideEffect(PlayerDetailsSideEffect.NavigateBack)
            PlayerDetailsEvent.PlayPause -> playPauseAction()
            is PlayerDetailsEvent.CurrentAudioChanged -> currentAudioChangedAction(index = event.index)
            is PlayerDetailsEvent.SeekTo -> seekToAction(position = event.position)
            is PlayerDetailsEvent.UpdateProgress -> updateProgressAction(progress = event.progress)
            is PlayerDetailsEvent.InitCurrentAudio -> initMusicItem(audioDataItem = event.audioDataItem)
        }
    }

    private fun musicStatesObserve() = intent {
        musicServiceHandler.musicStates.collectLatest { musicStates: MusicStates ->
            println("TAG: musicStates $musicStates")
            when (musicStates) {
                MusicStates.Initial -> initialMusicActions()
                is MusicStates.MediaBuffering -> {
                    reduce { state.copy(isLoading = true) }
                    progressCalculation(musicStates.progress)
                }

                is MusicStates.MediaPlaying -> changePlaying(isPlaying = musicStates.isPlaying)
                is MusicStates.MediaProgress -> progressCalculation(musicStates.progress)
                is MusicStates.MediaReady -> setMediaReady(duration = musicStates.duration)
                MusicStates.ConnectionError -> errorShow()
            }
        }
    }

    private fun errorShow() = reducer {
        state.copy(
            isLoading = false,
            isConnectionError = true
        )
    }

    private fun setMediaReady(duration: Long) = reducer {
        state.copy(
            isLoading = false,
            isConnectionError = false,
            duration = duration,
            playerDetailsUIState = PlayerDetailsUIState.HomeReady
        )
    }

    private fun changePlaying(isPlaying: Boolean) =
        reducer { state.copy(isMusicPlaying = isPlaying) }

    private fun initialMusicActions() {
        setMusicItems()
        reducer { state.copy(playerDetailsUIState = PlayerDetailsUIState.InitialHome) }
    }

    private fun currentAudioChangedAction(index: Int) = intent {
        reduce { state.copy(isLoading = true) }
        musicServiceHandler.onMediaStateEvents(
            mediaStateEvents = MediaStateEvents.SelectedMusicChange(state.musicItem.url),
            selectedMusicIndex = index
        )
    }

    private fun playPauseAction() = intent {
        if (state.isMusicPlaying && state.progress == 0f) reduce { state.copy(isLoading = true) }
        musicServiceHandler.onMediaStateEvents(MediaStateEvents.PlayPause)
    }

    private fun seekToAction(position: Float) = intent {
        musicServiceHandler.onMediaStateEvents(
            mediaStateEvents = MediaStateEvents.SeekTo,
            seekPosition = ((state.duration * position) / 100f).toLong()
        )
    }

    private fun updateProgressAction(progress: Float) = intent {
        musicServiceHandler.onMediaStateEvents(
            mediaStateEvents = MediaStateEvents.MediaProgress(progress)
        )
        reduce {
            state.copy(
                progress = progress,
                isLoading = false
            )
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
        state.musicItem
            .toMediaItem()
            .also {
                withContext(Dispatchers.Main) {
                    musicServiceHandler.setMediaItem(it)
                }
            }
    }

    private fun progressCalculation(currentProgress: Long) = reducer {
        state.copy(progress = currentProgress.toProgressCalculate(duration = state.duration))
    }

    override fun onDispose() {
        intent { musicServiceHandler.onMediaStateEvents(MediaStateEvents.Stop) }
        super.onDispose()
    }
}