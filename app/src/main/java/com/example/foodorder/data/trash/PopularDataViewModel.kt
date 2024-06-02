package com.example.foodorder.data.trash

import androidx.lifecycle.ViewModel
import com.example.foodorder.data.trash.PopularDataRepository
import com.example.foodorder.data.trash.PopularData

class PopularDataViewModel(private val popularDataRepository: PopularDataRepository) : ViewModel() {

    suspend fun savePopularData(popularList: List<PopularData>) {
            popularDataRepository.savePopularData(popularList)
    }
    suspend fun getAllPopularData(): List<PopularData> {
        return popularDataRepository.getAllPopularData()
    }
}
// TODO LiveData or StateFlow in the ViewModel