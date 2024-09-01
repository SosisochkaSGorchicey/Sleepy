package com.core.domain.repository

import com.core.domain.model.supabase.StoryItem
import com.core.domain.model.supabase.SupabaseResult

interface SupabaseDatabaseRepository {
    suspend fun getStories(): SupabaseResult<List<StoryItem>>
}