package com.core.domain.usecase

import com.core.domain.model.localDB.ScheduleItem
import com.core.domain.repository.FirestoreRepository
import com.core.domain.repository.LocalDatabaseRepository
import com.core.domain.repository.SupabaseAuthRepository

class CreateScheduleItemUseCase(
    private val firestoreRepository: FirestoreRepository,
    private val localDatabaseRepository: LocalDatabaseRepository,
    private val supabaseAuthRepository: SupabaseAuthRepository
) {
    suspend operator fun invoke(scheduleItem: ScheduleItem) {
        val userId = supabaseAuthRepository.getUserId()
        println("TAG: userId $userId")

        localDatabaseRepository.saveScheduleItem(scheduleItem = scheduleItem)
        firestoreRepository.saveSchedule(
            userId = userId,
            scheduleItem = scheduleItem
        )
    }
}