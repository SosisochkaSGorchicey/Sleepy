package com.core.data.repository

import com.core.data.mapper.toDomain
import com.core.data.model.ArticleItemModel
import com.core.data.model.AudioDataItemModel
import com.core.data.model.AudioSectionModel
import com.core.data.model.StoryItemModel
import com.core.domain.model.ArticleItem
import com.core.domain.model.AudioItem
import com.core.domain.model.AudioSection
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

    override suspend fun stories(): Flow<SupabaseResult<List<StoryItem>>> = supabaseRequestFlow {
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

    override suspend fun articles(): Flow<SupabaseResult<List<ArticleItem>>> =
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

    private fun audios(): Flow<List<AudioItem>> = flow { //todo
        listOf(AudioItem(url = "https://storage.googleapis.com/exoplayer-test-media-0/play.mp3"))
    }

    override suspend fun audioSections(): Flow<SupabaseResult<List<AudioSection>>> = //todo refactor
        supabaseRequestFlow {
            val sections = postgrest
                .from(AUDIO_SECTIONS_TABLE)
                .select {
                    order(
                        column = COLUMN_ID,
                        order = Order.ASCENDING
                    )
                }
                .decodeList<AudioSectionModel>()

            val content = postgrest
                .from(AUDIO_CONTENT_TABLE)
                .select {
                    order(
                        column = COLUMN_ID,
                        order = Order.ASCENDING
                    )
                }
                .decodeList<AudioDataItemModel>()

            sections.map { sectionModel ->
                AudioSection(
                    name = sectionModel.name,
                    items = content
                        .filter { it.sectionId == sectionModel.id }
                        .map { it.toDomain() }
                )
            }
        }

    companion object {
        private const val STORIES_TABLE = "Stories"
        private const val ARTICLES_TABLE = "Articles"
        private const val AUDIO_SECTIONS_TABLE = "AudioSections"
        private const val AUDIO_CONTENT_TABLE = "AudioContent"
        private const val COLUMN_ID = "id"
    }
}