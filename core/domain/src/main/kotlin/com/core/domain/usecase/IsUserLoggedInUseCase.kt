package com.core.domain.usecase

import com.core.domain.model.supabase.auth.LoggedInState
import com.core.domain.repository.DataStoreRepository
import com.core.domain.repository.SupabaseAuthRepository
import io.github.jan.supabase.gotrue.SessionStatus
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class IsUserLoggedInUseCase(
    private val supabaseAuthRepository: SupabaseAuthRepository,
    private val dataStoreRepository: DataStoreRepository
) {
    operator fun invoke(): Flow<LoggedInState> = flow<LoggedInState> {
        supabaseAuthRepository.isUserLoggedIn().collect { loggedInState ->
            when {
                loggedInState is LoggedInState.Error -> {
                    try {
                        supabaseAuthRepository.refresh()
                        supabaseAuthRepository.getSessionStatus().collect { result ->
                            when (result) {
                                is SessionStatus.LoadingFromStorage -> LoggedInState.Loading
                                is SessionStatus.Authenticated -> LoggedInState.LoggedIn
                                is SessionStatus.NotAuthenticated -> LoggedInState.NotLoggedIn
                                is SessionStatus.NetworkError -> LoggedInState.Error(loggedInState.supabaseResult)
                            }.run { emit(this) }
                        }
                    } catch (e: Throwable) {
                        dataStoreRepository.deleteToken()
                        emit(LoggedInState.NotLoggedIn)
                    }
                }

                else -> emit(loggedInState)
            }
        }
    }
}