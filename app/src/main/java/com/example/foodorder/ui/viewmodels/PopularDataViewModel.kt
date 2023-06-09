package com.example.foodorder.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.foodorder.data.database.PopularDataRepository
import com.example.foodorder.data.models.PopularData
import com.example.foodorder.data.models.User

class PopularDataViewModel(private val popularDataRepository: PopularDataRepository) : ViewModel() {

    suspend fun savePopularData(popularList: List<PopularData>) {
            popularDataRepository.savePopularData(popularList)
    }
    suspend fun getAllPopularData(): List<PopularData> {
        return popularDataRepository.getAllPopularData()
    }
}