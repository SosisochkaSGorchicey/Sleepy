package com.core.data.repository

import com.core.domain.model.localDB.ScheduleItem
import com.core.domain.repository.FirestoreRepository
import com.google.firebase.firestore.FirebaseFirestore

class FirestoreRepositoryImpl(
    private val firebaseFirestore: FirebaseFirestore
) : FirestoreRepository {
    override suspend fun saveSchedule(userId: String, schedule: ScheduleItem) {
        val scheduleRef = firebaseFirestore
            .collection("users")
            .document(userId)
            .collection("schedule")

        scheduleRef.add(schedule)
            .addOnSuccessListener { documentReference ->
                println("TAG: Firestore Расписание добавлено с ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                println("TAG: Firestore Ошибка добавления расписания $e")
            }
    }
}