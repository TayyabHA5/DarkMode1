package com.example.darkmode1

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatDelegate

class ThemeHelper(context: Context) {
    companion object {
        private const val KEY_THEME_MODE = "theme_mode"
    }
    private val sharedPreferences : SharedPreferences =
        context.getSharedPreferences("myPref",Context.MODE_PRIVATE)

    fun getThemeMode() : Int {
        return sharedPreferences.getInt(KEY_THEME_MODE,AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
    }
    fun savedThemeMode(themeMode : Int){
        sharedPreferences.edit().putInt(KEY_THEME_MODE,themeMode).apply()
    }

}