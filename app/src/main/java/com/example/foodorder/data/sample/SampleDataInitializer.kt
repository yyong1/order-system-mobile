package com.example.foodorder.data.sample

import com.example.foodorder.data.dao.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SampleDataInitializer(
    private val categoryDao: CategoryDao,
    private val restaurantDao: RestaurantDao,
    private val menuDao: MenuDao,
    private val orderDao: OrderDao,
    private val orderMenuDao: OrderMenuDao
) {

    fun insertSampleData() {
        CoroutineScope(Dispatchers.IO).launch {
            categoryDao.insertAll(SampleData.categories)
            restaurantDao.insertAll(SampleData.restaurants)
            menuDao.insertAll(SampleData.menus)
            orderDao.insertAll(SampleData.orders)
            orderMenuDao.insertAll(SampleData.orderMenus)
        }
    }
}
