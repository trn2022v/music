package com.example.myapplication.data.storage.room

import androidx.room.Dao
import androidx.room.Insert
import com.example.myapplication.data.storage.room.entity.Reg
import java.net.PasswordAuthentication

@Dao
interface RegDao {
    @Insert
    fun savePassword(password: Reg)
}