package com.core.data.repository

import com.core.domain.model.localDB.ScheduleItem
import com.core.domain.repository.FirestoreRepository
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class FirestoreRepositoryImpl(
    private val firebaseFirestore: FirebaseFirestore,
) : FirestoreRepository {

    private val _scheduleItems: MutableStateFlow<List<ScheduleItem>> = MutableStateFlow(emptyList())
    override val scheduleItems = _scheduleItems.asStateFlow()

    private val scheduleRef = { userId: String ->
        firebaseFirestore
            .collection("users")
            .document(userId)
            .collection("schedule")
    }

    override suspend fun saveSchedule(userId: String, scheduleItem: ScheduleItem) {
        scheduleRef(userId).add(scheduleItem)
            .addOnSuccessListener { documentReference ->
                println("TAG: Firestore Расписание добавлено с ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                println("TAG: Firestore Ошибка добавления расписания $e")
            }
    }

    override suspend fun updateSchedule(userId: String, scheduleItem: ScheduleItem) {
        scheduleRef(userId)
            .document(scheduleItem.id)
            .update(
                mapOf(
                    "createPush" to scheduleItem.createPush,
                    "descriptionText" to scheduleItem.descriptionText,
                    "millisecondOfDay" to scheduleItem.millisecondOfDay,
                    "titleText" to scheduleItem.titleText,
                )
            )
            .addOnSuccessListener { println("TAG: DocumentSnapshot successfully updated!") }
            .addOnFailureListener { e -> println("TAG: Error updating document $e") }
    }

    override suspend fun delete(userId: String, scheduleItemId: String) {
        scheduleRef(userId)
            .document(scheduleItemId)
            .delete()
            .addOnSuccessListener { println("TAG: DocumentSnapshot successfully deleted!") }
            .addOnFailureListener { e -> println("TAG: Error deleting document $e") }
    }

    override fun observeScheduleForUser(userId: String) {
        scheduleRef(userId).addSnapshotListener { snapshots, error ->
            if (error != null) {
                println("TAG: Ошибка получения обновлений $error")
                return@addSnapshotListener
            }

            if (snapshots != null) {
                val scheduleList = mutableListOf<ScheduleItem>()
                for (document in snapshots.documents) {
                    val schedule = document.toObject(ScheduleItem::class.java)
                    if (schedule != null) {
                        scheduleList.add(schedule.copy(id = document.id))
                    }
                }
                _scheduleItems.value = scheduleList
            }
        }
    }
}