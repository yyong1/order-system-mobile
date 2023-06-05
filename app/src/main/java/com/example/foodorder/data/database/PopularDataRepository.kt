package com.example.foodorder.data.database

import com.example.foodorder.data.dao.PopularDataDao
import com.example.foodorder.data.models.PopularData

class PopularDataRepository(private val popularDataDao: PopularDataDao) {
    suspend fun savePopularData(popularList: List<PopularData>) {
        popularDataDao.insertAll(popularList)
    }

    suspend fun getAllPopularData(): List<PopularData> {
        return popularDataDao.getAllPopularData()
    }
}