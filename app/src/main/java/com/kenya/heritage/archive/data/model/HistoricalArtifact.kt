package com.kenya.heritage.archive.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.kenya.heritage.archive.data.local.Converters

enum class AssetType { IMAGE, VIDEO, AUDIO }
enum class HistoricalCategory { POLITICAL, SOCIAL, ECONOMIC, CULTURAL }

data class MediaAsset(
    val url: String,
    val type: AssetType,
    val thumbnailUrl: String? = null,
    val caption: String? = null
)

@Entity(tableName = "historical_artifacts")
data class HistoricalArtifact(
    @PrimaryKey val id: String,
    val title: String,
    val year: Int,
    val period: String,
    val deepNarrative: String,
    val foreignerTips: String? = null,
    val latitude: Double? = null,
    val longitude: Double? = null,
    val category: HistoricalCategory,
    val mediaAssets: List<MediaAsset>,
    val isFeatured: Boolean = false,
    val historicalEpoch: String? = null,
    val locationName: String? = null,
    // NEW: Decade-level rich content
    val bannerImageUrl: String? = null,       // GitHub raw image URL shown in Era of Day
    val decadeDescription: String? = null,    // Summary of the whole decade
    val significantEvent: String? = null,     // Key headline event of this year
    val funFact: String? = null               // Fascinating trivia about this year/decade
)
