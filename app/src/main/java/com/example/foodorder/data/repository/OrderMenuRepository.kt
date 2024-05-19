package com.example.foodorder.data.repository

import com.example.foodorder.data.dao.OrderMenuDao
import com.example.foodorder.data.models.OrderMenu


class OrderMenuRepository(private val orderMenuDao: OrderMenuDao) {
    suspend fun saveOrderMenu(orderMenu: OrderMenu) = orderMenuDao.insert(orderMenu)
    suspend fun getAllOrderMenus(): List<OrderMenu> = orderMenuDao.getAllOrderMenus()
}