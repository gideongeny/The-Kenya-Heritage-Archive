package com.kenya.heritage.archive.data.util

/**
 * Resolves GitHub raw URLs for images and videos hosted in the repository.
 * Base URL: https://raw.githubusercontent.com/gideongeny/The-Kenya-Heritage-Archive/main/
 */
object GitHubAssetResolver {
    private const val BASE = "https://raw.githubusercontent.com/gideongeny/The-Kenya-Heritage-Archive/main"

    /**
     * Returns an image URL for the given year, pulling from the decade subfolders.
     * Use a deterministic index (per era) to cycle through images in that folder.
     */
    /**
     * Resolve an image for a specific year.
     * If the decade folder doesn't exist (pre-1890), it falls back to the 1890s pool.
     */
    fun imageForYear(year: Int, index: Int = 0): String {
        val eraPath = if (year < 1963) "Pre%20Independence%20Kenya" else "Post%20Independence%20Kenya"
        val decade = (year / 10) * 10
        val decadeStr = "${decade}s"
        
        // Find the folder in manifest or fallback to 1890s for ancient eras
        val eraKey = if (year < 1963) "Pre Independence Kenya" else "Post Independence Kenya"
        val folderKey = "$eraKey/$decadeStr"
        
        val files = MediaManifest.imagesByDecade[folderKey] 
            ?: MediaManifest.imagesByDecade["Pre Independence Kenya/1890s"] 
            ?: emptyList()
            
        if (files.isEmpty()) {
             // Absolute safety fallback
             return "$BASE/images/Pre%20Independence%20Kenya/1910s/Kenya-Tribes.webp"
        }
        
        val fileName = files[index % files.size]
        return "$BASE/images/${eraPath}/${decadeStr}/$fileName"
    }

    /**
     * Find all videos in the manifest that match the given year or decade.
     */
    fun getVideosForYear(year: Int): List<String> {
        return MediaManifest.allVideos.filter { fileName ->
            fileName.startsWith(year.toString()) || 
            (year in 1952..1960 && fileName.contains("Mau Mau", ignoreCase = true)) ||
            (year in 1950..1959 && fileName.contains("1950", ignoreCase = true))
        }.map { "$BASE/videos/${it.replace(" ", "%20")}" }
    }

    /**
     * Returns a specific image from a decade folder.
     */
    fun specificImage(year: Int, fileNameWithExtension: String): String {
        val era = if (year < 1963) "Pre%20Independence%20Kenya" else "Post%20Independence%20Kenya"
        val decade = (year / 10) * 10
        val encodedFile = fileNameWithExtension.replace(" ", "%20").replace("(", "%20(").replace(")", ")")
        return "$BASE/images/$era/${decade}s/$encodedFile"
    }

    /**
     * Returns the GitHub raw video URL for a given video filename.
     */
    fun videoUrl(filename: String): String = "$BASE/videos/${filename.replace(" ", "%20")}"

    /**
     * Attempts to find a video for a year or keyword.
     * This is used by the seeder to map videos like "MauMau" or "1963".
     */
    fun findVideoByKeyword(keyword: String, existingVideos: List<String>): String? {
        return existingVideos.find { it.contains(keyword, ignoreCase = true) }?.let { videoUrl(it) }
    }
}
