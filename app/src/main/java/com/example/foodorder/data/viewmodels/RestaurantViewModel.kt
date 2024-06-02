package com.example.foodorder.data.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodorder.data.models.Restaurant
import com.example.foodorder.data.repository.RestaurantRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RestaurantViewModel(private val repository: RestaurantRepository) : ViewModel() {
    private val _allRestaurants = MutableStateFlow<List<Restaurant>>(emptyList())
    val allRestaurants: StateFlow<List<Restaurant>> = _allRestaurants.asStateFlow()

    init {
        fetchAllRestaurants()
    }

    fun fetchAllRestaurants() {
        viewModelScope.launch {
            val restaurants = repository.getAllRestaurants()
            _allRestaurants.value = restaurants
        }
    }
}