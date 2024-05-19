package com.example.foodorder.data.repository

import com.example.foodorder.data.dao.UserDao
import com.example.foodorder.data.models.User

class UserRepository(private val userDao: UserDao) {
    suspend fun registerUser(user: User) = userDao.insert(user)
    suspend fun getUserById(userId: Int): User? = userDao.getUserById(userId)
    suspend fun getUserByEmail(email: String): User? = userDao.getUserByEmail(email)
}