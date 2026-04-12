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
    fun imageForYear(year: Int, index: Int = 0): String {
        val era = if (year < 1963) "Pre%20Independence%20Kenya" else "Post%20Independence%20Kenya"
        val decade = (year / 10) * 10
        
        // Comprehensive list of common filename patterns found in the repository
        val filePatterns = buildList {
            add("download.jpg")
            add("images.jpg")
            for (i in 1..20) {
                add("download%20($i).jpg")
                add("images%20($i).jpg")
            }
            add("Kenya-Tribes.webp")
        }
        
        val fileName = filePatterns[index % filePatterns.size]
        return "$BASE/images/$era/${decade}s/$fileName"
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
