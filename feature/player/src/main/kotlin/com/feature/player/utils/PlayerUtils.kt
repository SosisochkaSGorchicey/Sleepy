package com.feature.player.utils

import androidx.media3.common.MediaItem
import com.core.domain.model.AudioItem

fun Long.toProgressCalculate(duration: Long): Float =
    if (this > 0) (this.toFloat() / duration.toFloat()) * 100f else 0f

fun AudioItem.toMediaItem(): MediaItem =
    MediaItem.Builder()
        .setUri(this.url)
//                .setMediaMetadata( todo
//                    MediaMetadata.Builder()
//                        .setAlbumArtist(audioItem.artist)
//                        .setDisplayTitle(audioItem.title)
//                        .setSubtitle(audioItem.displayName)
//                        .build()
//                )
        .build()
