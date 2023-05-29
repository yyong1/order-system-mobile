package com.example.foodorder.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.foodorder.data.models.User

@Dao
interface UserDao {
    @Query("SELECT * FROM users WHERE id = :userId")
    fun getUserById(userId: String): User?

    @Insert
    fun insertUser(user: User)
}