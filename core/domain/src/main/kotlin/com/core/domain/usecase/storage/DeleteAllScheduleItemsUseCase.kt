package com.core.domain.usecase.storage

import com.core.domain.repository.FirestoreRepository
import com.core.domain.repository.SupabaseAuthRepository
import kotlinx.coroutines.flow.first

class DeleteAllScheduleItemsUseCase(
    private val firestoreRepository: FirestoreRepository,
    private val supabaseAuthRepository: SupabaseAuthRepository
) {
    suspend operator fun invoke() {
        val userId = supabaseAuthRepository.getUserId()
        val items = firestoreRepository.scheduleItems.first()

        items.forEach { item ->
            firestoreRepository.delete(
                userId = userId,
                scheduleItemId = item.id
            )
        }
    }
}