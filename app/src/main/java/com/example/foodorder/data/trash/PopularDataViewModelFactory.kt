package com.example.foodorder.data.trash


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PopularDataViewModelFactory(private val popularDataRepository: PopularDataRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PopularDataViewModel::class.java)) {
            return PopularDataViewModel(popularDataRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}