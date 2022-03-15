package com.example.myapplication.data.storage.room

import android.content.Context

class RegDatabaseImpl:RegUser {

    private var instance: RegDatabaseImpl? =null
    private var regDao: RegDao? = null

    private lateinit var context: Context

    fun getInstance(context: Context): RegDatabaseImpl {
        if (instance == null) {
            instance = RegDatabaseImpl()
            regDao= RegDatabase.buildDatabase(context).regUser()

        }
        return instance!!

    }
    override fun regDatabase(): RegDao = regDao!!

}