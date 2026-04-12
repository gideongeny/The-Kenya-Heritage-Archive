package com.kenya.heritage.archive.data.local

import androidx.room.*
import com.kenya.heritage.archive.data.model.HistoricalArtifact
import com.kenya.heritage.archive.data.model.HistoricalCategory
import kotlinx.coroutines.flow.Flow

@Dao
interface ArtifactDao {
    @Query("SELECT * FROM historical_artifacts ORDER BY year ASC")
    fun getAllArtifacts(): Flow<List<HistoricalArtifact>>

    @Query("SELECT * FROM historical_artifacts WHERE year BETWEEN :startYear AND :endYear ORDER BY year ASC")
    fun getArtifactsByYearRange(startYear: Int, endYear: Int): Flow<List<HistoricalArtifact>>

    @Query("SELECT * FROM historical_artifacts WHERE isFeatured = 1 ORDER BY year DESC LIMIT 1")
    fun getFeaturedArtifact(): Flow<HistoricalArtifact?>

    @Query("SELECT * FROM historical_artifacts WHERE category = :category ORDER BY year ASC")
    fun getByCategory(category: HistoricalCategory): Flow<List<HistoricalArtifact>>

    @Query("SELECT * FROM historical_artifacts WHERE title LIKE '%' || :query || '%' OR deepNarrative LIKE '%' || :query || '%' OR locationName LIKE '%' || :query || '%' ORDER BY year ASC")
    fun searchArtifacts(query: String): Flow<List<HistoricalArtifact>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArtifacts(artifacts: List<HistoricalArtifact>)

    @Query("DELETE FROM historical_artifacts")
    suspend fun clearAll()

    @Query("SELECT COUNT(*) FROM historical_artifacts")
    suspend fun count(): Int
}

@Database(entities = [HistoricalArtifact::class], version = 2, exportSchema = false)
@TypeConverters(Converters::class)
abstract class ArtifactDatabase : RoomDatabase() {
    abstract fun artifactDao(): ArtifactDao
}
