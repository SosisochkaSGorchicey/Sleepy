package com.core.domain.usecase.auth

import com.core.domain.model.supabase.SupabaseResult
import com.core.domain.repository.SupabaseAuthRepository
import com.core.domain.utils.supabaseRequestFlow
import kotlinx.coroutines.flow.Flow

class SignUpAnonymously(
    private val supabaseAuthRepository: SupabaseAuthRepository
) {
    operator fun invoke(): Flow<SupabaseResult<Unit>> = supabaseRequestFlow {
        supabaseAuthRepository.signAnonim()
        supabaseAuthRepository.trySaveToken()
    }
}