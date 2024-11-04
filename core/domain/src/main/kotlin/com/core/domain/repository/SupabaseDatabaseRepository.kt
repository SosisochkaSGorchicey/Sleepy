package com.core.domain.repository

import com.core.domain.model.ArticleItem
import com.core.domain.model.AudioItem
import com.core.domain.model.AudioSection
import com.core.domain.model.supabase.StoryItem
import com.core.domain.model.supabase.SupabaseResult
import kotlinx.coroutines.flow.Flow

interface SupabaseDatabaseRepository {
    suspend fun stories(): Flow<SupabaseResult<List<StoryItem>>>
    suspend fun articles(): Flow<SupabaseResult<List<ArticleItem>>>
    suspend fun audios(): Flow<List<AudioItem>> //todo

    suspend fun audioSections(): Flow<SupabaseResult<List<AudioSection>>>
}