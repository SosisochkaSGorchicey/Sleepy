package com.core.domain.usecase.storage

import com.core.domain.repository.FirestoreRepository
import com.core.domain.repository.SupabaseAuthRepository
import kotlinx.coroutines.flow.first

class DeleteScheduleItemsForWeekdayUseCase(
    private val firestoreRepository: FirestoreRepository,
    private val supabaseAuthRepository: SupabaseAuthRepository
) {
    suspend operator fun invoke(idOfWeekItem: Int) {
        val userId = supabaseAuthRepository.getUserId()
        val items = firestoreRepository.scheduleItems.first()

        items
            .filter { it.weekDayId == idOfWeekItem }
            .forEach { item ->
                firestoreRepository.delete(
                    userId = userId,
                    scheduleItemId = item.id
                )
            }
    }
}