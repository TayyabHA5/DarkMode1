package com.example.darkmode1

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate


import com.example.darkmode1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var themeHelper: ThemeHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        themeHelper= ThemeHelper(this)

        applyTheme(themeHelper.getThemeMode())
        setSupportActionBar(binding.toolBar)
    }

    private fun applyTheme(themeMode: Int) {
      AppCompatDelegate.setDefaultNightMode(themeMode)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item, menu)

        val toggleTheme = menu?.findItem(R.id.darkMode)
        toggleTheme?.isChecked = themeHelper.getThemeMode() == AppCompatDelegate.MODE_NIGHT_YES
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.darkMode -> {
                val isDarkMode = !item.isChecked
                item.isChecked = isDarkMode

                themeHelper.savedThemeMode(if (isDarkMode) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO)


                applyTheme(if (isDarkMode) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }
}
