package com.example.myapplication.data.storage.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.data.storage.room.entity.Reg

@Database(entities = [Reg::class], version = 1)
abstract class RegDatabase : RoomDatabase(), RegDao {

    companion object{
        fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            RegDatabase::class.java,
            "RegDatabase"
        ).build()

    }

    abstract fun regUser(): RegDao

}