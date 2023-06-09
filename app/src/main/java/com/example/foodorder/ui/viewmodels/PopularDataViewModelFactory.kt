package com.example.foodorder.ui.viewmodels


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.foodorder.data.database.PopularDataRepository

class PopularDataViewModelFactory(private val popularDataRepository: PopularDataRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PopularDataViewModel::class.java)) {
            return PopularDataViewModel(popularDataRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}