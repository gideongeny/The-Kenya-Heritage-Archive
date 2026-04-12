package com.kenya.heritage.archive.media

import android.content.Context
import androidx.media3.database.StandaloneDatabaseProvider
import androidx.media3.datasource.DataSource
import androidx.media3.datasource.DefaultDataSource
import androidx.media3.datasource.okhttp.OkHttpDataSource
import okhttp3.OkHttpClient
import java.io.File

object VideoCacheManager {
    private var cache: SimpleCache? = null
    private const val MAX_CACHE_SIZE = 500 * 1024 * 1024L // 500MB

    private val okHttpClient = OkHttpClient.Builder()
        .followRedirects(true)
        .followSslRedirects(true)
        .build()

    @androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)
    private fun getCache(context: Context): SimpleCache {
        return cache ?: synchronized(this) {
            val cacheDir = File(context.cacheDir, "history_media_cache")
            val evictor = LeastRecentlyUsedCacheEvictor(MAX_CACHE_SIZE)
            val databaseProvider = StandaloneDatabaseProvider(context)
            SimpleCache(cacheDir, evictor, databaseProvider).also { cache = it }
        }
    }

    @androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)
    fun getCacheDataSourceFactory(context: Context): DataSource.Factory {
        val okHttpDataSourceFactory = OkHttpDataSource.Factory(okHttpClient)

        val defaultDataSourceFactory = DefaultDataSource.Factory(context, okHttpDataSourceFactory)

        return CacheDataSource.Factory()
            .setCache(getCache(context))
            .setUpstreamDataSourceFactory(defaultDataSourceFactory)
            .setFlags(CacheDataSource.FLAG_IGNORE_CACHE_ON_ERROR)
    }

    @androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)
    fun releaseCache() {
        cache?.release()
        cache = null
    }
}
