package com.feature.audioContent.presentation.screenmodel

import com.core.common.mvi.MviScreenModel
import com.core.common.mvi.reducer
import com.core.domain.model.supabase.SupabaseResult
import com.core.domain.repository.SupabaseDatabaseRepository
import com.core.ui.utils.toTextRes
import org.orbitmvi.orbit.syntax.simple.intent

class AudioContentScreenModel(
    private val supabaseDatabaseRepository: SupabaseDatabaseRepository
) : MviScreenModel<AudioContentState, AudioContentSideEffect, AudioContentEvent>(
    initialState = AudioContentState()
) {

    init {
        initContent()
    }

    override fun onEvent(event: AudioContentEvent) {
        when (event) {
            AudioContentEvent.ReloadData -> initContent()
        }
    }

    private fun initContent() = intent {
        supabaseDatabaseRepository.audioSections().collect {
            it.observeResult {
                reducer { state.copy(audioContent = it) }
            }
        }
    }

    private fun <T> SupabaseResult<T>.observeResult(successAction: (T) -> Unit) {
        when (this) {
            is SupabaseResult.Error -> reducer {
                state.copy(
                    inLoading = false,
                    errorTextRes = this@observeResult.errorType.toTextRes()
                )
            }

            SupabaseResult.Loading ->
                reducer { state.copy(inLoading = true, errorTextRes = null) }

            is SupabaseResult.Success -> {
                successAction(this.data)
                reducer { state.copy(inLoading = false, errorTextRes = null) }
            }
        }
    }
}