package com.core.domain.usecase

import com.core.domain.model.SupabaseResult
import com.core.domain.repository.SupabaseAuthRepository
import com.core.domain.utils.supabaseFlowRequest
import kotlinx.coroutines.flow.Flow

class SignUpAnonymously(
    private val supabaseAuthRepository: SupabaseAuthRepository
) {
    operator fun invoke(): Flow<SupabaseResult<Unit>> = supabaseFlowRequest {
        supabaseAuthRepository.signAnonim()
        supabaseAuthRepository.trySaveToken()
    }
}