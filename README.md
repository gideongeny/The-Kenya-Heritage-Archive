# 🇰🇪 The Kenya Heritage Archive

[![Android Build](https://img.shields.io/badge/Platform-Android-green.svg)](https://developer.android.com)
[![Kotlin](https://img.shields.io/badge/Language-Kotlin-blue.svg)](https://kotlinlang.org)
[![Content](https://img.shields.io/badge/History-1100--2026-orange.svg)](#)

**The Kenya Heritage Archive** is a premium, immersive digital time capsule dedicated to preserving the rich tapestry of Kenyan history. From the dawn of the Swahili civilization in the 11th century to the digital revolution of 2026, this application serves as a gateway to our ancestors' stories, struggles, and triumphs.

## 🏛 Key Features

- **Historical Timeline**: Navigate through over 900 years of history, from pre-colonial kingdoms and the arrival of explorers to the birth of a republic.
- **The Vault**: A high-speed digital archival gallery featuring over **200+ historical images** and **70+ rare archival videos**.
- **Mau Mau Archives**: Dedicated archival footage of the land and freedom struggle, including the capture of Field Marshal Dedan Kimathi.
- **Offline-First Excellence**: Designed for connectivity resilience, allowing you to carry our history anywhere, anytime.
- **Foreigner's Guide**: An optional educational layer providing context and tips for international users learning about Kenyan culture for the first time.

## 🎥 Archival Media

The app leverages a dynamic GitHub-hosted asset repository to deliver high-quality archival footage without bloating the initial app size:
- **images/[Era]/[Decade]s/**: Systematic organization for rapid asset discovery.
- **videos/**: Keyword-indexed video retrieval for rare footage (e.g., Lari Massacre trials, Independence Day celebrations).

## 🛡 Privacy & Transparency

- **No Data Harvesting**: We believe history belongs to the people. No personal data is collected or shared.
- **Educational Intent**: This is a non-profit archival project intended for research, education, and national pride.

## 🛠 Technology Stack

- **UI**: Jetpack Compose (Material 3)
- **Engine**: Kotlin Coroutines & StateFlow
- **Media**: Media3 ExoPlayer & Coil for image caching
- **Architecture**: Clean Architecture with MVVM & Room Persistence
- **Content**: Custom seeder with deep narratives for every historical milestone

## 🏗 Installation

1. Clone the repository.
2. Open in Android Studio (Ladybug or later).
3. Build and run on any Android device with SDK 24+.

---

*Dedicated to all those who fought for the soil and the soul of Kenya.*
