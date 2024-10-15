package com.core.domain.usecase

import com.core.domain.model.supabase.SupabaseResult
import com.core.domain.repository.SupabaseAuthRepository
import com.core.domain.utils.supabaseRequestFlow
import kotlinx.coroutines.flow.Flow

class SignInUseCase(
    private val supabaseAuthRepository: SupabaseAuthRepository
) {
    operator fun invoke(
        email: String,
        password: String
    ): Flow<SupabaseResult<Unit>> = supabaseRequestFlow {
        supabaseAuthRepository.signIn(
            email = email,
            password = password
        )
        supabaseAuthRepository.trySaveToken()
    }
}