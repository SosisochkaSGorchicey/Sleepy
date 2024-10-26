package com.core.domain.repository

import com.core.domain.model.ArticleItem
import com.core.domain.model.AudioItem
import com.core.domain.model.supabase.StoryItem
import com.core.domain.model.supabase.SupabaseResult
import kotlinx.coroutines.flow.Flow

interface SupabaseDatabaseRepository {
    suspend fun getStories(): Flow<SupabaseResult<List<StoryItem>>>
    suspend fun getArticles(): Flow<SupabaseResult<List<ArticleItem>>>
    suspend fun getAudios(): Flow<List<AudioItem>> //todo
}