package com.example.foodorder.data.repository

import com.example.foodorder.data.dao.RestaurantDao
import com.example.foodorder.data.models.Restaurant

class RestaurantRepository(private val restaurantDao: RestaurantDao) {
    suspend fun saveRestaurant(restaurant: Restaurant) = restaurantDao.insert(restaurant)
    suspend fun getAllRestaurants(): List<Restaurant> = restaurantDao.getAllRestaurants()
}