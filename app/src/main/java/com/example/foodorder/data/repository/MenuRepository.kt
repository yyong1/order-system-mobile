package com.example.foodorder.data.repository

import com.example.foodorder.data.dao.MenuDao
import com.example.foodorder.data.models.Menu
import kotlinx.coroutines.flow.Flow

class MenuRepository(private val menuDao: MenuDao) {
    suspend fun getMenuById(menuId: Int): Menu? {
        return menuDao.getMenuById(menuId)
    }
    suspend fun saveMenu(menu: Menu) = menuDao.insert(menu)
    fun getAllMenus(): Flow<List<Menu>> {
        return menuDao.getAllMenus()
    }
    fun getMenusByRestaurantId(restaurantId: Int): Flow<List<Menu>> {
        return menuDao.getMenusByRestaurantId(restaurantId)
    }
}
