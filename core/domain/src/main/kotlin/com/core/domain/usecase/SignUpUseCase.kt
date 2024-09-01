package com.core.domain.usecase

import com.core.domain.model.supabase.SupabaseResult
import com.core.domain.repository.SupabaseAuthRepository
import com.core.domain.utils.supabaseFlowRequest
import kotlinx.coroutines.flow.Flow

class SignUpUseCase(
    private val supabaseAuthRepository: SupabaseAuthRepository
) {
    operator fun invoke(
        userName: String,
        email: String,
        password: String
    ): Flow<SupabaseResult<Unit>> = supabaseFlowRequest {
        supabaseAuthRepository.signUp(
            userName = userName,
            email = email,
            password = password
        )
        supabaseAuthRepository.trySaveToken()
    }
}