package com.example.myapplication.data.local.auth

import com.example.myapplication.data.storage.room.UserDao
import com.example.myapplication.data.storage.room.entity.UserEntity
import com.example.myapplication.utils.isEmailValid

class LocalAuthDataSource : LocalAuthDataSourceI {

    override suspend fun onSignIn(email: String, password: String): Boolean = UserDao.getUser(email)?.run {
        val userPassword = this.password
        val isPasswordTheSame = userPassword == password

        return if (isPasswordTheSame) {
            preferences.saveUserToken(this.id ?: 0)
            isPasswordTheSame
        } else {
            false
        }
    } ?: false

    override suspend fun signUp(email: String, password: String) {
        userDao.insert(UserEntity(login = email, password = password))
        val token = userDao.getUser(login = email)?.id ?: 0
        preferences.saveUserToken(token)
    }

    override suspend fun checkEmail(email: String): Boolean {
        val isValid = email.isEmailValid()
        val user = userDao.getUser(email)

        return isValid && user == null
    }

    override suspend fun checkPasswords(password: String, repeatedPassword: String): Boolean =
        password.isNotBlank() && repeatedPassword.isNotBlank() &&
                password.isPasswordValid() && repeatedPassword.isPasswordValid() && password == repeatedPassword

    override suspend fun logout() = preferences.saveUserToken(null)
