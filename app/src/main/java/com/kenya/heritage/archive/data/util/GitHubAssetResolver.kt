package com.kenya.heritage.archive.data.util

/**
 * Resolves GitHub raw URLs for images and videos hosted in the repository.
 * Base URL: https://raw.githubusercontent.com/gideongeny/The-Kenya-Heritage-Archive/main/
 */
object GitHubAssetResolver {
    private const val BASE = "https://raw.githubusercontent.com/gideongeny/The-Kenya-Heritage-Archive/main"

    // Pre-independence images: 76 total (index 0..75)
    private val preImages = buildList {
        add("$BASE/images/Pre%20Independence%20Kenya/Kenya-Tribes.webp")
        add("$BASE/images/Pre%20Independence%20Kenya/download.jpg")
        for (i in 1..41) add("$BASE/images/Pre%20Independence%20Kenya/download%20($i).jpg")
        add("$BASE/images/Pre%20Independence%20Kenya/images.jpg")
        for (i in 1..32) add("$BASE/images/Pre%20Independence%20Kenya/images%20($i).jpg")
    }

    // Post-independence images: 119 total
    private val postImages = buildList {
        add("$BASE/images/Post%20Independence%20Kenya/download.jpg")
        for (i in 1..43) add("$BASE/images/Post%20Independence%20Kenya/download%20($i).jpg")
        add("$BASE/images/Post%20Independence%20Kenya/images.jpg")
        for (i in 1..67) add("$BASE/images/Post%20Independence%20Kenya/images%20($i).jpg")
        add("$BASE/images/Post%20Independence%20Kenya/image_750x_649ab6eee0af1.jpg")
        add("$BASE/images/Post%20Independence%20Kenya/rss-efe608864e18af3ee39bc62731d2786b53c3772947dw.webp")
    }

    /**
     * Returns an image URL for the given year — rotates through the available images by decade.
     */
    fun imageForYear(year: Int): String {
        return if (year < 1963) {
            val index = ((year - 1000) / 10) % preImages.size
            preImages[index.coerceIn(0, preImages.size - 1)]
        } else {
            val index = ((year - 1963) / 5) % postImages.size
            postImages[index.coerceIn(0, postImages.size - 1)]
        }
    }

    /**
     * Returns a deterministic image for a given decade (e.g., 1960, 1970, 1980...).
     */
    fun imageForDecade(decade: Int): String = imageForYear(decade)

    /**
     * Returns the GitHub raw video URL for a given video filename.
     */
    fun videoUrl(filename: String): String = "$BASE/videos/${filename.replace(" ", "%20")}"
}
