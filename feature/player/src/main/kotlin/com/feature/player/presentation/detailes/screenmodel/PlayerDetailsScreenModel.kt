package com.feature.player.presentation.detailes.screenmodel

import androidx.media3.common.MediaItem
import com.core.common.mvi.MviScreenModel
import com.core.common.mvi.emitSideEffect
import com.core.common.mvi.reducer
import com.core.domain.repository.SupabaseDatabaseRepository
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
    private val musicServiceHandler: MusicServiceHandler,
    private val supabaseDatabaseRepository: SupabaseDatabaseRepository
) : MviScreenModel<PlayerDetailsState, PlayerDetailsSideEffect, PlayerDetailsEvent>(
    initialState = PlayerDetailsState()
) {


    init {

        println("TAG: !!! this $this")
        println("TAG: !!! musicServiceHandler $musicServiceHandler")

        getMusicData()



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
                    is MusicStates.CurrentMediaPlaying -> {
                        state.musicList.getOrNull(musicStates.mediaItemIndex)?.let {
                            reduce {
                                state.copy(currentSelectedMusic = it)
                            }
                        }

                    }
//                        reduce {
//                        state.copy(currentSelectedMusic = state.musicList[musicStates.mediaItemIndex])
//                    }

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
                    MediaStateEvents.SelectedMusicChange,
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
        }
    }

    private fun getMusicData() {
        intent {
            supabaseDatabaseRepository.audios().collect {
                reduce { state.copy(musicList = it) }
            }


        }
    }

    private fun setMusicItems() = intent {
        state.musicList.map { audioItem ->
            MediaItem.Builder()
                .setUri(audioItem.url)
//                .setMediaMetadata( todo
//                    MediaMetadata.Builder()
//                        .setAlbumArtist(audioItem.artist)
//                        .setDisplayTitle(audioItem.title)
//                        .setSubtitle(audioItem.displayName)
//                        .build()
//                )
                .build()
        }.also {
            withContext(Dispatchers.Main) {
                musicServiceHandler.setMediaItemList(it)
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
        println("TAG: !!!!onDispose")
        intent { musicServiceHandler.onMediaStateEvents(MediaStateEvents.Stop) }
        super.onDispose()
    }
}