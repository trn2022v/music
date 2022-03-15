package com.example.myapplication.data.storage.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Reg(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "token")
    val token: Int,

    @ColumnInfo(name = "Name")
    val userName: String,
    @ColumnInfo(name = "login")
    val login: String,
    @ColumnInfo(name = "password")
    val password: String
)
