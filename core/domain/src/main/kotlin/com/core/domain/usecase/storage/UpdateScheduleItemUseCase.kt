package com.core.domain.usecase.storage

import com.core.domain.model.localDB.ScheduleItem
import com.core.domain.repository.FirestoreRepository
import com.core.domain.repository.SupabaseAuthRepository

class UpdateScheduleItemUseCase(
    private val firestoreRepository: FirestoreRepository,
    private val supabaseAuthRepository: SupabaseAuthRepository
) {
    suspend operator fun invoke(scheduleItem: ScheduleItem) {

    }
}