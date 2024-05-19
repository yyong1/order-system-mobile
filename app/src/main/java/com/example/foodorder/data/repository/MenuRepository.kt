package com.example.foodorder.data.repository

import com.example.foodorder.data.dao.MenuDao
import com.example.foodorder.data.models.Menu

class MenuRepository(private val menuDao: MenuDao) {
    suspend fun saveMenu(menu: Menu) = menuDao.insert(menu)
    suspend fun getAllMenus(): List<Menu> = menuDao.getAllMenus()
}
