package com.example.myapplication.data.storage.room.user.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.data.storage.room.user.entity.UserEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM user_table WHERE id = :id")
    suspend fun findUserById(id: Long): UserEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser(userEntity: UserEntity)

    @Query("DELETE FROM user_table WHERE id =:id")
    suspend fun deleteUser(id: Long): Int

}