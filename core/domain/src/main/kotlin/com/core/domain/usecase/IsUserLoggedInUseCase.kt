package com.core.domain.usecase

import com.core.domain.model.supabase.LoggedInState
import com.core.domain.repository.DataStoreRepository
import com.core.domain.repository.SupabaseAuthRepository
import io.github.jan.supabase.gotrue.SessionStatus
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class IsUserLoggedInUseCase(
    private val supabaseAuthRepository: SupabaseAuthRepository,
    private val dataStoreRepository: DataStoreRepository
) {
    operator fun invoke(): Flow<LoggedInState> =
        supabaseAuthRepository.isUserLoggedIn().map { loggedInState ->
            when {
                loggedInState is LoggedInState.Error -> {
                    try {
                        supabaseAuthRepository.refresh()
                        supabaseAuthRepository.getSessionStatus().collect {
                            println("TAG: SessionStatus $it")
                            when (it) {
                                is SessionStatus.LoadingFromStorage -> LoggedInState.Loading
                                is SessionStatus.Authenticated -> LoggedInState.LoggedIn
                                is SessionStatus.NotAuthenticated -> LoggedInState.NotLoggedIn
                                is SessionStatus.NetworkError -> LoggedInState.Error(loggedInState.supabaseResult)
                            }
                        }
                    } catch (e: Throwable) {
                        dataStoreRepository.deleteToken()
                        LoggedInState.NotLoggedIn
                    }
                }

                else -> loggedInState
            }
        }
}