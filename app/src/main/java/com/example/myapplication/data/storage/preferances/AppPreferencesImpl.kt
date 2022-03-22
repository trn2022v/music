package com.example.myapplication.data.storage.preferances

import android.content.Context
import android.content.SharedPreferences

class AppPreferencesImpl() : AppPreferences {


    companion object {
        private const val PREFERENCE_NAME = "AppPreferences"
        private const val PREFERENCE_IS_SAVE_CREDENTIALS_SELECTED =
            "PREFERENCE_IS_SAVE_CREDENTIALS_SELECTED"
        private const val PREFERENCE_LOGIN = "PREFERENCE_LOGIN"
        private const val PREFERENCE_PASSWORD = "PREFERENCE_PASSWORD"
        private const val PREFERENCE_TOKEN = "PREFERENCE_TOKEN"
        private var preferences: SharedPreferences? = null
        private var instance: AppPreferences? = null

        fun getInstance(context: Context): AppPreferences {
            if (instance == null) {
                instance = AppPreferencesImpl()
                preferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
            }
            return instance!!
        }
    }

    fun initPreferences(context: Context) {
        preferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
    }

    override fun isSaveCredentialSelected(): Boolean {
        return preferences?.getBoolean(PREFERENCE_IS_SAVE_CREDENTIALS_SELECTED, false) ?: false
    }

    override fun setSaveCredentialIsSelected(isSelected: Boolean) {
        preferences?.edit()?.putBoolean(PREFERENCE_IS_SAVE_CREDENTIALS_SELECTED, isSelected)
            ?.apply()
    }

    override fun saveLogin(login: String) {
        preferences?.edit()?.putString(PREFERENCE_LOGIN, login)
            ?.apply()
    }

    override fun savePassword(password: String) {
        preferences?.edit()?.putString(PREFERENCE_PASSWORD, password)
            ?.apply()
    }

    override fun saveToken(token: String) {
        preferences?.edit()?.putString(PREFERENCE_TOKEN, token)?.apply() ?: Unit
    }

    override fun getLogin(): String {
        return preferences?.getString(PREFERENCE_LOGIN, "") ?: ""
    }

    override fun getPassword(): String {
        return preferences?.getString(PREFERENCE_PASSWORD, "") ?: ""
    }

    override fun getToken(): String {
        return preferences?.getString(PREFERENCE_TOKEN, "") ?: ""
    }

}