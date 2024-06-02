package com.example.foodorder.data.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.foodorder.data.repository.RestaurantRepository

class RestaurantViewModelFactory(private val restaurantRepository: RestaurantRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RestaurantViewModel::class.java)) {
            return RestaurantViewModel(restaurantRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
