package com.core.domain.usecase

import com.core.domain.model.supabaseAuth.AuthErrorType
import com.core.domain.model.supabaseAuth.LoggedInState
import com.core.domain.repository.SupabaseAuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class IsUserLoggedInUseCase(
    private val supabaseAuthRepository: SupabaseAuthRepository
) {
    operator fun invoke(): Flow<LoggedInState> = supabaseAuthRepository.isUserLoggedIn().map {
        when {
            it is LoggedInState.Error -> {
                when (it.supabaseResult.errorType) {
                    AuthErrorType.Timeout -> it
                    AuthErrorType.HttpRequest -> it
                    else -> LoggedInState.NotLoggedIn
                }
            }

            else -> it
        }
    }
}