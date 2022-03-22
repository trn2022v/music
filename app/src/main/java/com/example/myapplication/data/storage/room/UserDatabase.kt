package com.example.myapplication.data.storage.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.data.storage.room.entity.User

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase(), UserDao {

    companion object{
        fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            UserDatabase::class.java,
            "user_database"
        ).build()

    }

    abstract fun regUser(): UserDao

}