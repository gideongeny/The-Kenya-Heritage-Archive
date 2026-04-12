package com.kenya.heritage.archive.data.util

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat

/**
 * Manages in-app language switching between English and Swahili.
 * Uses AppCompatDelegate.setApplicationLocales() which works from API 21+
 * via the AndroidX AppCompat compatibility library.
 */
object LanguageManager {

    private const val PREF_NAME = "heritage_language"
    private const val KEY_LANGUAGE = "selected_language"
    const val LANG_ENGLISH = "en"
    const val LANG_SWAHILI = "sw"

    fun getCurrentLanguage(context: Context): String {
        return getPrefs(context).getString(KEY_LANGUAGE, LANG_ENGLISH) ?: LANG_ENGLISH
    }

    fun setLanguage(context: Context, languageCode: String) {
        getPrefs(context).edit().putString(KEY_LANGUAGE, languageCode).apply()
        applyLanguage(languageCode)
    }

    fun applyLanguage(languageCode: String) {
        val localeList = LocaleListCompat.forLanguageTags(languageCode)
        AppCompatDelegate.setApplicationLocales(localeList)
    }

    fun applyStoredLanguage(context: Context) {
        val stored = getCurrentLanguage(context)
        applyLanguage(stored)
    }

    fun isSwahili(context: Context) = getCurrentLanguage(context) == LANG_SWAHILI

    private fun getPrefs(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }
}
