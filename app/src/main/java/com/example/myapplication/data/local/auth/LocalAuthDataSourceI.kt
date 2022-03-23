package com.example.myapplication.data.local.auth

interface LocalAuthDataSourceI {
    suspend fun onSingIn(email: String, password: String): Boolean
    suspend fun signUp(email: String, password: String)
    suspend fun checkEmail(email: String): Boolean
    suspend fun checkPasswords(password: String, repeatedPassword: String): Boolean
    suspend fun logout()
}