package com.core.data.repository

import com.core.data.utils.isChainError
import com.core.data.utils.toSupabaseError
import com.core.domain.model.supabaseAuth.LoggedInState
import com.core.domain.repository.DataStoreRepository
import com.core.domain.repository.SupabaseAuthRepository
import io.github.jan.supabase.gotrue.Auth
import io.github.jan.supabase.gotrue.SessionStatus
import io.github.jan.supabase.gotrue.providers.builtin.Email
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put

class SupabaseAuthRepositoryImpl(
    private val auth: Auth,
    private val dataStoreRepository: DataStoreRepository
) : SupabaseAuthRepository {
    override suspend fun signIn(email: String, password: String) {
        auth.signInWith(Email) {
            this.email = email
            this.password = password
        }
    }

    override suspend fun trySaveToken() {
        val accessToken = auth.currentAccessTokenOrNull()
        println("TAG: in trySaveToken accessToken $accessToken")
        accessToken?.let {
            dataStoreRepository.saveToken(newToken = accessToken)
        }
    }

    override suspend fun signAnonim() {
        auth.signInAnonymously(data = createUserData(ANONYMOUS_USER_NAME))
    }

    override suspend fun signUp(
        userName: String,
        email: String,
        password: String
    ) {
        auth.signUpWith(Email) {
            this.email = email
            this.password = password
            this.data = createUserData(userName)
        }
    }

    override fun isUserLoggedIn(): Flow<LoggedInState> = flow {  //todo?
        emit(LoggedInState.Loading)
        val token = dataStoreRepository.getToken().first()

        try {
            if (token.isNotEmpty()) {
                tokenCheck(token = token)
                //loggedInActions()
                emit(LoggedInState.LoggedIn)
            } else {
                //userDataRepository.getUserName()
                emit(LoggedInState.NotLoggedIn)
            }
        } catch (e: Exception) {

            println("TAG: isUserLoggedIn e $e")

            emit(LoggedInState.Error(e.toSupabaseError()))

//            refresh() //todo?
//
//            if (e.isChainError()) {
//                dataStoreRepository.deleteToken()
//                emit(LoggedInState.NotLoggedIn)
//            } else {
//                auth.sessionStatus.collect {
//                    println("TAG: SessionStatus $it")
//                    when (it) {
//                        is SessionStatus.LoadingFromStorage -> emit(LoggedInState.Loading)
//                        is SessionStatus.Authenticated -> {
//                            //loggedInActions()
//                            emit(LoggedInState.LoggedIn)
//                        }
//
//                        is SessionStatus.NotAuthenticated -> {
//                            //userDataRepository.getUserName()
//                            emit(LoggedInState.NotLoggedIn)
//                        }
//
//                        else -> emit(LoggedInState.Error(e.toSupabaseError()))
//                    }
//                }
//            }
        }
    }

    private suspend fun tokenCheck(token: String) {
        auth.retrieveUser(token)
        auth.refreshCurrentSession()
        trySaveToken()
    }

    private suspend fun refresh() {
        runCatching {
            auth.startAutoRefreshForCurrentSession()
        }
    }

    private fun createUserData(userName: String): JsonObject =
        buildJsonObject {
            put(key = USER_NAME_KEY, value = userName)
        }

    companion object {
        private const val USER_NAME_KEY = "user_name"
        private const val ANONYMOUS_USER_NAME = "Guest"
    }
}