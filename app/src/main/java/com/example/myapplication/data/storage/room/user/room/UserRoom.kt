package com.example.myapplication.data.storage.room.user.room

import com.example.myapplication.data.local.auth.User
import com.example.myapplication.data.storage.room.user.UserRepository
import com.example.myapplication.data.storage.room.user.entity.toUserEntity
import javax.inject.Inject

class UserRoom @Inject constructor(
    private val userDao: UserDao
) : UserRepository {
    override suspend fun findUserById(userId: Long): User? {
        return userDao.findUserById(userId)?.toUser()
    }

    override suspend fun addUser(user: User) {
        userDao.addUser(user.toUserEntity())
    }

    override suspend fun deleteUser(userId: Long) {
        userDao.deleteUser(userId)
    }
}