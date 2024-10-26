package com.core.data.repository

import com.core.data.mapper.toDomain
import com.core.data.model.ArticleItemModel
import com.core.data.model.StoryItemModel
import com.core.domain.model.ArticleItem
import com.core.domain.model.AudioItem
import com.core.domain.model.supabase.StoryItem
import com.core.domain.model.supabase.SupabaseResult
import com.core.domain.repository.SupabaseDatabaseRepository
import com.core.domain.utils.supabaseRequestFlow
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.query.Order
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SupabaseDatabaseRepositoryImpl(
    private val postgrest: Postgrest
) : SupabaseDatabaseRepository {
    override suspend fun getStories(): Flow<SupabaseResult<List<StoryItem>>> = supabaseRequestFlow {
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

    override suspend fun getArticles(): Flow<SupabaseResult<List<ArticleItem>>> =
        supabaseRequestFlow {
            postgrest
                .from(ARTICLES_TABLE)
                .select {
                    order(
                        column = COLUMN_ID,
                        order = Order.ASCENDING
                    )
                }
                .decodeList<ArticleItemModel>()
                .map { it.toDomain() }
        }

    override suspend fun getAudios(): Flow<List<AudioItem>> = flow {
        listOf(AudioItem(url = "https://storage.googleapis.com/exoplayer-test-media-0/play.mp3"))
    }

    companion object {
        private const val STORIES_TABLE = "Stories"
        private const val ARTICLES_TABLE = "Articles"
        private const val COLUMN_ID = "id"
    }
}