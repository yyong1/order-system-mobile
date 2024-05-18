package com.example.foodorder.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.foodorder.data.models.RestaurantData

@Dao
interface RestaurantDataDao {
    @Insert
    suspend fun insertRestaurant(restaurant: RestaurantData)

    @Query("SELECT * FROM restaurantData")
    suspend fun getAllRestaurants(): List<RestaurantData>

    @Query("SELECT * FROM restaurantData WHERE isPopular = 1")
    suspend fun getPopularRestaurants(): List<RestaurantData>
}