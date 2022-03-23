package com.example.myapplication.domain

import javax.inject.Inject

class SignInInteractor @Inject constructor(private val authRepository: AuthRepositoryI) : SignInIteractorI {
    override suspend fun onSignIn(email: String, password: String): Boolean =
        authRepository.onSignIn(email, password)
}