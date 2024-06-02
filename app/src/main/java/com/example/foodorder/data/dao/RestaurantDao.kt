package com.example.foodorder.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.foodorder.data.models.Order
import com.example.foodorder.data.models.Restaurant

@Dao
interface RestaurantDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(restaurant: List<Restaurant>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(restaurant: Restaurant)

    @Query("SELECT * FROM restaurants WHERE id = :restaurantId")
    suspend fun getRestaurantById(restaurantId: Int): Restaurant?

    @Query("SELECT * FROM restaurants")
    suspend fun getAllRestaurants(): List<Restaurant>
}