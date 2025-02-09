package com.core.domain.usecase

import com.core.domain.repository.FirestoreRepository
import com.core.domain.repository.SupabaseAuthRepository

class ObserveScheduleItemUseCase(
    private val firestoreRepository: FirestoreRepository,
    private val supabaseAuthRepository: SupabaseAuthRepository
) {
    suspend operator fun invoke() {
        val userId = supabaseAuthRepository.getUserId()
        firestoreRepository.observeScheduleForUser(userId = userId)
    }
}