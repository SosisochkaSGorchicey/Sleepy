package com.feature.audioContent.presentation.screenmodel

import com.core.common.mvi.MviScreenModel
import com.core.domain.repository.SupabaseDatabaseRepository
import org.orbitmvi.orbit.syntax.simple.intent

class AudioContentScreenModel(
    private val supabaseDatabaseRepository: SupabaseDatabaseRepository
) : MviScreenModel<AudioContentState, AudioContentSideEffect, AudioContentEvent>(
        initialState = AudioContentState()
    ) {

    init {
        intent {
            supabaseDatabaseRepository.audioSections().collect {
                println("TAG: audioSections $it")
            }
        }
    }

    override fun onEvent(event: AudioContentEvent) {
        when (event) {

            else -> {}
        }
    }
}