package com.kenya.heritage.archive.data.util

/**
 * The Source of Truth for all media assets in the GitHub repository.
 * Filenames are stored as RAW strings. Encoding happens at the resolver level.
 */
object MediaManifest {
    
    val imagesByDecade = mapOf(
        "Pre Independence Kenya/1890s" to listOf(
             "images (1).jpg", "images (9).jpg"
        ),
        "Pre Independence Kenya/1910s" to listOf(
             "download (27).jpg", "download (31).jpg", "download (4).jpg", "download (8).jpg",
             "images (3).jpg", "images (4).jpg", "images (6).jpg", "images (8).jpg", "images.jpg",
             "Kenya-Tribes.webp"
        ),
        "Pre Independence Kenya/1920s" to listOf(
             "download (1).jpg", "download (12).jpg", "download (18).jpg", "download (2).jpg",
             "download (25).jpg", "download (3).jpg", "download (40).jpg", "download (5).jpg",
             "download (7).jpg", "images (11).jpg", "images (2).jpg", "images (5).jpg"
        ),
        "Pre Independence Kenya/1930s" to listOf(
             "download (10).jpg", "download (13).jpg", "download (19).jpg", "download (26).jpg",
             "images (12).jpg", "images (19).jpg"
        ),
        "Pre Independence Kenya/1940s" to listOf(
             "download (14).jpg", "download (17).jpg", "download (20).jpg", "download (21).jpg",
             "download (23).jpg", "download (28).jpg", "download (29).jpg", "download (30).jpg",
             "download (32).jpg", "download (39).jpg", "download (9).jpg", "images (25).jpg", "images (7).jpg"
        ),
        "Pre Independence Kenya/1950s" to listOf(
             "download (16).jpg", "download (22).jpg", "download (24).jpg", "download (33).jpg",
             "download (34).jpg", "download (35).jpg", "download (36).jpg", "download (37).jpg",
             "download (41).jpg", "download (6).jpg", "download.jpg", "images (10).jpg",
             "images (13).jpg", "images (14).jpg", "images (15).jpg", "images (16).jpg",
             "images (17).jpg", "images (18).jpg", "images (20).jpg", "images (21).jpg",
             "images (22).jpg", "images (23).jpg", "images (24).jpg", "images (26).jpg",
             "images (27).jpg", "images (28).jpg", "images (29).jpg", "images (30).jpg",
             "images (31).jpg", "images (32).jpg"
        ),
        "Post Independence Kenya/1960s" to listOf(
             "download (3).jpg", "download (4).jpg", "download (42).jpg", "download (5).jpg",
             "download (6).jpg", "download (8).jpg", "images (1).jpg", "images.jpg"
        ),
        "Post Independence Kenya/1970s" to listOf(
             "download (1).jpg", "download (15).jpg", "download (2).jpg", "images (11).jpg",
             "images (2).jpg", "images (3).jpg", "images (4).jpg", "images (5).jpg", "images (6).jpg"
        ),
        "Post Independence Kenya/1980s" to listOf(
             "download (18).jpg", "download (38).jpg", "download (3).jpg", "download (7).jpg",
             "download (8).jpg", "images (1).jpg", "images (12).jpg", "images (14).jpg",
             "images (15).jpg", "images (17).jpg", "images (18).jpg"
        ),
        "Post Independence Kenya/1990s" to listOf(
             "images (25).jpg", "images (27).jpg", "images (28).jpg", "images (31).jpg",
             "images (34).jpg", "images (41).jpg", "images (43).jpg", "images (50).jpg",
             "images (61).jpg", "images (9).jpg"
        ),
        "Post Independence Kenya/2000s" to listOf(
             "download (22).jpg", "download (23).jpg", "download (24).jpg", "download (29).jpg",
             "download (40).jpg", "images (18).jpg", "images (26).jpg", "images (29).jpg",
             "images (32).jpg", "images (36).jpg", "images (38).jpg", "images (44).jpg",
             "images (46).jpg", "images (47).jpg", "images (49).jpg", "images (51).jpg",
             "images (6).jpg", "images (66).jpg"
        ),
        "Post Independence Kenya/2010s" to listOf(
             "download (25).jpg", "download (26).jpg", "download (27).jpg", "download (30).jpg",
             "download (31).jpg", "download (32).jpg", "download (39).jpg", "download (41).jpg",
             "images (16).jpg", "images (24).jpg", "images (37).jpg", "images (40).jpg",
             "images (5).jpg", "images (53).jpg", "images (54).jpg", "images (55).jpg",
             "images (60).jpg", "images (62).jpg", "images (8).jpg"
        ),
        "Post Independence Kenya/2020s" to listOf(
             "20231020_133621.jpg", "download (28).jpg", "download (33).jpg", "download (34).jpg",
             "download (35).jpg", "download (36).jpg", "download (37).jpg", "download (43).jpg",
             "images (30).jpg", "images (39).jpg", "images (42).jpg", "images (52).jpg",
             "images (56).jpg", "images (57).jpg", "images (58).jpg", "images (63).jpg",
             "images (64).jpg", "images (65).jpg", "images (67).jpg"
        )
    )

    val allVideos = listOf(
        "1963 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "1964 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "1965 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "1966 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "1967 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "1968 _ 50 years of Independence _ Kenya History and Biographies (1).mp4",
        "1968 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "1969 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "1970 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "1971 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "1972 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "1973 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "1974 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "1975 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "1976 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "1977 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "1978 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "1979 _ 50 years of Independence _ Kenya History and Biographies (1).mp4",
        "1979 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "1980 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "1981 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "1982 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "1983 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "1984 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "1985 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "1986 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "1987 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "1988 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "1989 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "1990 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "1990_ 50 years of Independence _ Kenya History and Biographies.mp4",
        "1991 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "1992 _ 50 years of Independence _ Kenya History and Biographies (2).mp4",
        "1992 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "1993 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "1994 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "1995 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "1996 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "1997 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "1998 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "1999 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "2000 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "2001 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "2002 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "2003 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "2004 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "2005 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "2006 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "2007 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "2008_ 50 years of Independence _ Kenya History and Biographies.mp4",
        "2009 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "2010 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "2011 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "2012 _ 50 years of Independence _ Kenya History and Biographies.mp4",
        "African Safari (1964).mp4",
        "Amnesty offer to maumau.mp4",
        "An Open Air Xmas (1925).mp4",
        "Capture of Dedan Kimathi _ _Mau Mau_ Leader _ Kenya Land and Freedom Army (KLFA) _ October 1956.mp4",
        "EP 1 _ The Constitutional Road to Independence _ Kenya History and Biographies.mp4",
        "Gen china to  die.mp4",
        "General Nicholson Visits Kenya (1953).mp4",
        "kenya 1950s.mp4",
        "Kenya 1960s life.mp4",
        "Kenya Scenes (1961).mp4",
        "Lancashire Fusiliers In Kenya (1953).mp4",
        "MauMau victims funeral.mp4",
        "Native Farming (1950-1959).mp4",
        "New Parliament Building In Nairobi (1954).mp4",
        "Rare Raw Footage Nairobi, Kenya in 1968 Archival Film.mp4",
        "Selected Originals - Long Live The Queen Aka Queen Elizabeth II Returns From Kenya (1952).mp4",
        "Selected Originals - Mau Mau - Lari Massacre Trial (1953).mp4",
        "TomMboya funeral.mp4",
        "videoplayback (2).mp4",
        "videoplayback (3).mp4"
    )
}
