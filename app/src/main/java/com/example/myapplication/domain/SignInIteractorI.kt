package com.example.myapplication.domain

interface SignInIteractorI {
    suspend fun onSignIn(email: String, password: String): Boolean
}