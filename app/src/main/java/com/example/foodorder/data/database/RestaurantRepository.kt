package com.example.foodorder.data.database

import com.example.foodorder.data.dao.RestaurantDataDao
import com.example.foodorder.data.models.RestaurantData

class RestaurantRepository(private val restaurantDao: RestaurantDataDao) {
    suspend fun insertRestaurant(restaurant: RestaurantData) = restaurantDao.insertRestaurant(restaurant)
    suspend fun getAllRestaurants() = restaurantDao.getAllRestaurants()
    suspend fun getPopularRestaurants() = restaurantDao.getPopularRestaurants()
}