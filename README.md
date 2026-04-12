# 🇰🇪 The Kenya Heritage Archive (1100 – 2026)

[![Build Status](https://img.shields.io/badge/Build-Success-success?style=for-the-badge&logo=android)](https://github.com/gideongeny/The-Kenya-Heritage-Archive)
[![Platform](https://img.shields.io/badge/Platform-Android-green?style=for-the-badge&logo=android)](https://developer.android.com/android)
[![Kotlin](https://img.shields.io/badge/Kotlin-v1.9.0-blue?style=for-the-badge&logo=kotlin)](https://kotlinlang.org/)

**The Kenya Heritage Archive** is a premium, immersive digital time capsule documenting the rich, complex, and unyielding history of Kenya. From the 11th-century Swahili city-states to the digital "Silicon Savannah" of 2026, this application serves as a bridge across a millennium of heritage.

![Kenya Heritage Archive Banner](https://raw.githubusercontent.com/gideongeny/The-Kenya-Heritage-Archive/main/app/src/main/res/mipmap-xxxhdpi/ic_launcher.png)

## 🏛 The Experience

Designed with a **"Heritage Dark"** aesthetic inspired by the Kenyan shield and flag, the app offers an offline-first, cinematic journey through time:

- **🕰 Millennary Timeline**: A custom-engineered `TimelineScrubber` allowing users to glide through 1,000+ years of history instantly.
- **🎥 The Vault**: A high-speed, GitHub-integrated media engine that streams archival footage and high-resolution images of historical milestones.
- **📱 Proactive Discovery**: As you scrub, the app intelligently identifies and highlights available archival videos for the specific year you've selected.
- **🗺 Decade-by-Decade Enrichment**: Deeply researched narratives for every decade, featuring "Significant Occasions" and "Fascinating Fun Facts."
- **🌍 Foreigner’s Guide**: A toggleable cultural bridge providing international context for Kenyan cultural terms and practices.

## 🛠 Technical Stack

Built with modern Android standards for performance, longevity, and offline resilience:

- **Core**: Kotlin & Jetpack Compose (Declarative UI)
- **Engine**: Hilt (Dependency Injection) & Room (Offline Persistence)
- **Media**: Media3 / ExoPlayer (Video Streaming) with a 500MB Smart Cache
- **Imaging**: Coil with custom `VideoThumbnailLoader` for high-speed archival previews
- **Deployment**: Tiered Git strategy for high-bandwidth media management

## 🚀 Installation & Build

### Prerequisites
- Android Studio Hedgehog (2023.1.1) or newer
- JDK 17
- Android SDK 34 (API 34)

### Building from Source
```bash
# Clone the repository
git clone https://github.com/gideongeny/The-Kenya-Heritage-Archive.git

# Navigate to the project
cd "The Kenya Heritage Archive"

# Build the debug APK
./gradlew assembleDebug
```

## 📦 Repository Structure
- `/app`: Main Android module.
- `/images`: Curated library of 100+ historical images.
- `/videos`: Archival footage library (~1.2GB) synchronized via tiered deployment.

## 📜 Historical Note
This archive is a tribute to the sacrifice of the Mau Mau, the wisdom of the elders across all 47 counties, and the digital pioneers of the 21st century. It is built to ensure that while we look forward to the horizon, we never lose sight of our roots.

---
**Developed with pride for the Republic of Kenya.** 🇰🇪
