package com.example.foodorder.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.foodorder.data.models.User

@Dao
interface UserDao {
    @Query("SELECT * FROM users WHERE email = :userEmail")
    suspend fun getUserByEmail(userEmail: String): User?

    @Insert
    suspend fun insertUser(user: User)
}