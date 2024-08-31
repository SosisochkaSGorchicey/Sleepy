package com.core.data.repository

import com.core.data.mapper.toDomain
import com.core.data.model.StoryItemModel
import com.core.data.utils.supabaseRequest
import com.core.domain.model.supabase.StoryItem
import com.core.domain.model.supabase.SupabaseResult
import com.core.domain.repository.SupabaseDatabaseRepository
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.query.Order

class SupabaseDatabaseRepositoryImpl(
    private val postgrest: Postgrest
) : SupabaseDatabaseRepository {
    override suspend fun getStories(): SupabaseResult<List<StoryItem>> = supabaseRequest {
        postgrest
            .from(STORIES_TABLE)
            .select {
                order(
                    column = COLUMN_ID,
                    order = Order.ASCENDING
                )
            }
            .decodeList<StoryItemModel>()
            .map { it.toDomain() }
    }

    companion object {
        private const val STORIES_TABLE = "Stories"
        private const val COLUMN_ID = "id"
    }
}