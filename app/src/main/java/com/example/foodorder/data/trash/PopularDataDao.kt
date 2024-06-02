package com.example.foodorder.data.trash

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PopularDataDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(popularList: List<PopularData>)
    @Query("SELECT * FROM popularData WHERE resId = :popData")
    fun getPopularDataById(popData: String): PopularData?
    @Query("SELECT * FROM popularData")
    suspend fun getAllPopularData(): List<PopularData>
}