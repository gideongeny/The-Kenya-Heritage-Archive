package com.kenya.heritage.archive.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.kenya.heritage.archive.data.model.MediaAsset

class Converters {
    @TypeConverter
    fun fromMediaAssetList(value: List<MediaAsset>): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toMediaAssetList(value: String): List<MediaAsset> {
        val listType = object : TypeToken<List<MediaAsset>>() {}.type
        return Gson().fromJson(value, listType)
    }
}
