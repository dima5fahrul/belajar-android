package com.example.belajarandroid.local_data_persistent.shared_preferences

import android.content.Context

internal class UserPreference(context: Context) {
    companion object {
        private const val PREFS_NAME = "user_pref"
        private const val NAME = "name"
        private const val EMAIL = "email"
        private const val AGE = "age"
        private const val PHONE = "phone"
        private const val LOVE_MU = "islove"
    }

    private val preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun setUser(value: UserModel) {
        preferences.edit().apply {
            putString(NAME, value.name)
            putString(EMAIL, value.email)
            putInt(AGE, value.age)
            putString(PHONE, value.phoneNumber)
            putBoolean(LOVE_MU, value.isLove)
            apply()
        }
    }

    fun getUser(): UserModel {
        return UserModel().apply {
            name = preferences.getString(NAME, "")
            email = preferences.getString(EMAIL, "")
            age = preferences.getInt(AGE, 0)
            phoneNumber = preferences.getString(PHONE, "")
            isLove = preferences.getBoolean(LOVE_MU, false)
        }
    }
}