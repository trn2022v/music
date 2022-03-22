package com.example.myapplication.data.storage.room

import androidx.room.Dao
import androidx.room.Insert
import com.example.myapplication.data.storage.room.entity.User

@Dao
interface UserDao {
    @Insert
    fun addUser(password: User)
}