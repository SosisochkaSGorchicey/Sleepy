package com.core.domain.usecase.storage

import com.core.domain.repository.FirestoreRepository
import com.core.domain.repository.SupabaseAuthRepository

class DeleteScheduleItemUseCase(
    private val firestoreRepository: FirestoreRepository,
    private val supabaseAuthRepository: SupabaseAuthRepository
) {
    suspend operator fun invoke(scheduleItemId: String) {
        val userId = supabaseAuthRepository.getUserId()

        firestoreRepository.delete(
            userId = userId,
            scheduleItemId = scheduleItemId
        )
    }
}