package com.kenya.heritage.archive.data.util

import com.kenya.heritage.archive.data.model.*
import java.io.File
import java.util.*

object LocalAssetScanner {

    /**
     * Scans the user's `videos` folder and maps filenames to HistoricalArtifacts.
     * Expected naming: "YEAR _ Title.mp4" e.g. "1963 _ 50 years of Independence.mp4"
     */
    fun scanVideos(videosDir: File): List<HistoricalArtifact> {
        val artifacts = mutableListOf<HistoricalArtifact>()

        videosDir.listFiles()
            ?.filter { it.extension.lowercase() == "mp4" && it.length() > 10_000 }
            ?.forEach { file ->
                val fileName = file.nameWithoutExtension
                val yearMatch = Regex("^(\\d{4})").find(fileName)
                val year = yearMatch?.value?.toIntOrNull() ?: 1900
                val displayTitle = fileName
                    .replace(Regex("^\\d{4}\\s*[_|]\\s*"), "")
                    .replace("_", " ")
                    .trim()
                    .ifEmpty { fileName }

                val period = when {
                    year < 1500 -> "Pre-Colonial Period"
                    year < 1880 -> "The Age of Exploration"
                    year < 1920 -> "Early Colonial Era"
                    year < 1952 -> "Late Colonial Era"
                    year < 1963 -> "The Road to Independence"
                    year < 1978 -> "The First Republic"
                    year < 1990 -> "The Moi Era"
                    year < 2002 -> "The Multiparty Years"
                    year < 2013 -> "The Democratic Transition"
                    else -> "Modern Kenya"
                }

                artifacts.add(
                    HistoricalArtifact(
                        id = "video_${year}_${file.nameWithoutExtension.hashCode()}",
                        title = displayTitle,
                        year = year,
                        period = period,
                        historicalEpoch = period,
                        deepNarrative = buildNarrative(displayTitle, year, period),
                        foreignerTips = buildForeignerTip(year),
                        latitude = -1.286389,
                        longitude = 36.817222,
                        category = if (year < 1963) HistoricalCategory.POLITICAL else HistoricalCategory.SOCIAL,
                        mediaAssets = listOf(
                            MediaAsset(
                                url = GitHubAssetResolver.videoUrl(file.name),
                                type = AssetType.VIDEO,
                                thumbnailUrl = null,
                                caption = "Archival footage — $year"
                            )
                        ),
                        isFeatured = year == 1963,
                        locationName = "Kenya"
                    )
                )
            }

        return artifacts.sortedBy { it.year }
    }

    private fun buildNarrative(title: String, year: Int, period: String): String = when {
        year < 1963 -> """
            In $year, during the $period, this footage captures a moment etched in Kenya's memory — a time when the 
            seeds of a nation were being sown in the most difficult of soils. "$title" stands as a documentary witness 
            to the courage, pain, and resilience of those who came before us. Every frame tells the story of a land 
            fighting to reclaim its soul. These are the moments that our children and grandchildren must never forget — 
            the foundation upon which free Kenya was built.
        """.trimIndent()

        year == 1963 -> """
            December 12, $year. The Union Jack lowered. The green, black, red and white of Kenya rose for the first time. 
            "$title" documents this sacred hour — when Jomo Kenyatta's voice carried across the crowd at Uhuru Gardens 
            and an entire people exhaled after decades of colonial rule. This was not just political freedom; it was 
            the return of dignity to millions of Kenyans. The tears on every face in this footage are tears of 
            a people reborn. *Harambee!* — together we pull forward.
        """.trimIndent()

        year in 1964..1978 -> """
            In $year, a young republic was finding its feet. "$title" takes us inside the early years of Kenya's 
            nationhood — the bold infrastructure drives, the debates in parliament, the first Kenyan universities, 
            and the voices of leaders shaping the very idea of what it meant to be Kenyan. This was a time of 
            immense hope. Nairobi was growing, the Rift Valley was being tamed by Kenyan hands, and the world 
            was watching this young nation with admiration.
        """.trimIndent()

        year in 1979..1989 -> """
            The $year footage in "$title" captures Kenya at a complex crossroads — a nation maturing politically 
            with the introduction of single-party rule, yet simultaneously experiencing economic growth and social 
            development that was transforming her cities and her people. This decade saw Kenyans assert 
            themselves in global athletics, building a world-beating legacy on the track that would make every 
            Kenyan chest swell with pride.
        """.trimIndent()

        year in 1990..2002 -> """
            "$title" from $year documents one of Kenya's most turbulent — and ultimately triumphant — political 
            chapters. The clamor for multiparty democracy, the brave voices of civil society, the sacrifice of 
            activists, and finally the historic 2002 election that showed the world Kenya's democratic maturity. 
            This period was painful but necessary — the growing pains of a nation learning what true freedom means.
        """.trimIndent()

        else -> """
            By $year, Kenya had become the undeniable hub of East Africa. "$title" chronicles a modern superpower 
            in the making — M-Pesa's Silicon Savannah, world-class marathoners, conservation leadership, 
            and a young, vibrant population dreaming bigger than ever before. This footage is proof that 
            Kenya's best chapters are still being written, and every Kenyan holds the pen.
        """.trimIndent()
    }

    private fun buildForeignerTip(year: Int): String = when {
        year < 1963 -> "Kenya was a British Colony from 1895 to 1963. The territory was exploited for its fertile highlands, which were seized from indigenous communities, particularly the Kikuyu people."
        year == 1963 -> "'Harambee' (meaning 'Let us all pull together' in Swahili) became the national motto, symbolizing Kenya's commitment to national unity and self-reliance after independence."
        year in 1964..1978 -> "Kenya's first President, Jomo Kenyatta, led the nation through its foundational years. His political philosophy of 'Harambee' emphasized community self-help and national unity."
        year in 1979..1989 -> "Daniel arap Moi succeeded Kenyatta and led Kenya under KANU (Kenya African National Union) during a period of single-party rule that began in 1982."
        year in 1990..2002 -> "The 2002 elections saw NARC's Mwai Kibaki defeat KANU's Uhuru Kenyatta, marking Kenya's first peaceful democratic transfer of power in its history — a watershed moment for African democracy."
        else -> "Kenya is often called the 'Silicon Savannah' due to its thriving tech and startup ecosystem, led globally by M-Pesa — a mobile money platform that revolutionized financial inclusion worldwide."
    }
}
