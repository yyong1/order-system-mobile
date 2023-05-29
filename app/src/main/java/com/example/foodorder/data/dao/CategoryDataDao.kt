package com.example.foodorder.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.foodorder.data.models.CategoryData

@Dao
interface CategoryDataDao {
    @Query("SELECT * FROM categoryData WHERE redId = :catData")
    fun getCategoryDataById(catData: String): CategoryData?
}