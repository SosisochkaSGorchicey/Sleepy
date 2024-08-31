package com.core.data.mapper

import com.core.data.model.StoryItemModel
import com.core.domain.model.supabase.StoryItem

fun StoryItemModel.toDomain(): StoryItem =
    StoryItem(
        url = this.url,
        isImage = this.isImage
    )