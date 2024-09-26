package com.mindstix.onboarding.utils

import android.content.Context
import android.content.SharedPreferences

class SharedPreferenceManager(context: Context) {

    companion object {
        private const val PREF_NAME = "user_prefs"
        private const val KEY_IS_LOGGED_IN = "is_logged_in"
    }

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    // Getter for the isLoggedIn status
    var isLoggedIn: Boolean
        get() = sharedPreferences.getBoolean(KEY_IS_LOGGED_IN, false) // Default is false
        set(value) {
            sharedPreferences.edit().putBoolean(KEY_IS_LOGGED_IN, value).apply()
        }
}
