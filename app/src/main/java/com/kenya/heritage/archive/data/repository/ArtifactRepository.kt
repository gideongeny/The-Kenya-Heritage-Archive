package com.kenya.heritage.archive.data.repository

import com.kenya.heritage.archive.data.local.ArtifactDao
import com.kenya.heritage.archive.data.model.HistoricalArtifact
import com.kenya.heritage.archive.data.util.HistoricalSeeder
import kotlinx.coroutines.flow.Flow
import java.io.File
import javax.inject.Inject
import javax.inject.Singleton

interface ArtifactRepository {
    fun getArtifacts(): Flow<List<HistoricalArtifact>>
    fun getArtifactsByRange(startYear: Int, endYear: Int): Flow<List<HistoricalArtifact>>
    fun getFeaturedArtifact(): Flow<HistoricalArtifact?>
    suspend fun refreshArtifacts()
    suspend fun insertSeeds(artifacts: List<HistoricalArtifact>)
    suspend fun count(): Int
    suspend fun seedFromLocalFolders(videosDir: File)
}

@Singleton
class ArtifactRepositoryImpl @Inject constructor(
    private val artifactDao: ArtifactDao
) : ArtifactRepository {

    override fun getArtifacts(): Flow<List<HistoricalArtifact>> =
        artifactDao.getAllArtifacts()

    override fun getArtifactsByRange(startYear: Int, endYear: Int): Flow<List<HistoricalArtifact>> =
        artifactDao.getArtifactsByYearRange(startYear, endYear)

    override fun getFeaturedArtifact(): Flow<HistoricalArtifact?> =
        artifactDao.getFeaturedArtifact()

    override suspend fun insertSeeds(artifacts: List<HistoricalArtifact>) {
        artifactDao.insertArtifacts(artifacts)
    }

    override suspend fun count(): Int = artifactDao.count()

    override suspend fun refreshArtifacts() {
        artifactDao.clearAll()
    }

    override suspend fun seedFromLocalFolders(videosDir: File) {
        val localArtifacts = com.kenya.heritage.archive.data.util.LocalAssetScanner.scanVideos(videosDir)
        val deepNarratives = HistoricalSeeder.getDeepHeritageStitch()
        artifactDao.insertArtifacts(localArtifacts + deepNarratives)
    }
}
