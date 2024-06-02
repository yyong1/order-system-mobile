package com.example.foodorder.data.trash

class PopularDataRepository(private val popularDataDao: PopularDataDao) {
    suspend fun savePopularData(popularList: List<PopularData>) {
        popularDataDao.insertAll(popularList)
    }

    suspend fun getAllPopularData(): List<PopularData> {
        return popularDataDao.getAllPopularData()
    }
}