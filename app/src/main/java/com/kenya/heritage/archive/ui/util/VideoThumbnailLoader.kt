package com.kenya.heritage.archive.ui.util

import android.content.Context
import coil.ImageLoader
import coil.decode.VideoFrameDecoder
import coil.request.ImageRequest
import coil.request.videoFrameMillis
import com.kenya.heritage.archive.data.model.AssetType
import com.kenya.heritage.archive.data.model.HistoricalArtifact

object VideoThumbnailLoader {
    fun createThumbnailRequest(context: Context, artifact: HistoricalArtifact): ImageRequest? {
        val videoAsset = artifact.mediaAssets.firstOrNull { it.type == AssetType.VIDEO } ?: return null
        val videoUri = videoAsset.url.replace("local://", "")
        
        return ImageRequest.Builder(context)
            .data(videoUri)
            .videoFrameMillis(1000) // Capture frame at 1s
            .crossfade(true)
            .build()
    }

    fun getImageLoader(context: Context): ImageLoader {
        return ImageLoader.Builder(context)
            .components {
                add(VideoFrameDecoder.Factory())
            }
            .build()
    }
}
