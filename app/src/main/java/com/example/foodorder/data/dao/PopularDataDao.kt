package com.example.foodorder.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.foodorder.data.models.PopularData

@Dao
interface PopularDataDao {
    @Query("SELECT * FROM popularData WHERE resId = :popData")
    fun getPopularDataById(popData: String): PopularData?
}