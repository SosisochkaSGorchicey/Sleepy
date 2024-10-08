package com.core.data.mapper

import com.core.data.model.ArticleItemModel
import com.core.data.model.StoryItemModel
import com.core.domain.model.ArticleItem
import com.core.domain.model.supabase.StoryItem

fun StoryItemModel.toDomain(): StoryItem =
    StoryItem(
        url = this.url,
        isImage = this.isImage,
        previewUrl = this.previewUrl
    )

fun ArticleItemModel.toDomain(): ArticleItem =
    ArticleItem(
        id = this.id,
        title = this.title,
        description = this.description,
        backgroundImageUrl = this.backgroundImageUrl,
        isFullSize = this.isFullSize,
        textIsLight = this.textIsLight
    )