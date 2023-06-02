package com.example.foodorder.data.database

import com.example.foodorder.data.dao.UserDao
import com.example.foodorder.data.models.User

class UserRepository(private val userDao: UserDao) {

    suspend fun registerUser(user: User) {
        userDao.insertUser(user)
    }

    suspend fun getUserByEmail(email: String): User? {
        return userDao.getUserByEmail(email)
    }
}