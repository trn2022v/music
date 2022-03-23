package com.example.myapplication.data.storage.preferances

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class AppPreferencesImpl@Inject constructor(@ApplicationContext context: Context) :
    AppPreferences{


companion object {
        private const val PREFERENCES_NAME = "AppSharedPreferences"
        private const val EMAIL_KEY = "EMAIL_KEY"
        private const val PASSWORD_KEY = "PASSWORD_KEY"
        private const val USER_TOKEN = "USER_TOKEN"
    }

    private val preferences: SharedPreferences =
        context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)

    override fun saveEmail(email: String) {
        preferences.edit().putString(EMAIL_KEY, email).apply()
    }

    override fun savePassword(password: String) {
        preferences.edit().putString(PASSWORD_KEY, password).apply()
    }

    override fun saveUserToken(token: Int?) {
        preferences.edit().putString(USER_TOKEN, (token ?: "").toString()).apply()
    }

    override fun getEmail(): String = preferences.getString(EMAIL_KEY, "") ?: ""

    override fun getPassword(): String = preferences.getString(PASSWORD_KEY, "") ?: ""

    override fun getUserToken(): String = preferences.getString(USER_TOKEN, "") ?: ""
}


