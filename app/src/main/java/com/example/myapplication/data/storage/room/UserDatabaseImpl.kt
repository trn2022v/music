package com.example.myapplication.data.storage.room

import android.content.Context

class UserDatabaseImpl:RegUser {

    private var instance: UserDatabaseImpl? =null
    private var userDao: UserDao? = null

    private lateinit var context: Context

    fun getInstance(context: Context): UserDatabaseImpl {
        if (instance == null) {
            instance = UserDatabaseImpl()
            userDao= UserDatabase.buildDatabase(context).regUser()

        }
        return instance!!

    }
    override fun regDatabase(): UserDao = userDao!!

}