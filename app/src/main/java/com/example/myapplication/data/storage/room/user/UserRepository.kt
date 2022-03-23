package com.example.myapplication.data.storage.room.user

import com.example.myapplication.data.local.auth.User

interface UserRepository {
    suspend fun findUserById(userId: Long): User?

    suspend fun addUser(user: User)

    suspend fun deleteUser(userId: Long)

}