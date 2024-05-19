package com.example.foodorder.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.foodorder.data.models.Category

@Dao
interface CategoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(category: Category)

    @Query("SELECT * FROM category WHERE categoryId = :categoryId")
    suspend fun getCategoryById(categoryId: Int): Category?

    @Query("SELECT * FROM category")
    suspend fun getAllCategories(): List<Category>
}