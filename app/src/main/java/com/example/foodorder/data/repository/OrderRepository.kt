package com.example.foodorder.data.repository;

import com.example.foodorder.data.dao.OrderDao;
import com.example.foodorder.data.models.Order;
import com.example.foodorder.data.models.OrderMenu
import java.util.Date

class OrderRepository(private val orderDao: OrderDao) {
    suspend fun saveOrder(order: Order) {
        orderDao.insert(order)
    }

    suspend fun getAllOrders():List<Order> {
        return orderDao.getAllOrders()
    }

    suspend fun getOrderById(orderId: Int): Order? {
        return orderDao.getOrderById(orderId)
    }

    fun getOrdersByDateRange(userId: Int, startDate: Date, endDate: Date): List<Order> {
        return orderDao.getOrdersByDateRange(userId, startDate, endDate)
    }

    fun getLastOrder(userId: Int): Order? {
        return orderDao.getLastOrder(userId)
    }

    fun insertOrderMenu(orderMenu: OrderMenu) {
        orderDao.insertOrderMenu(orderMenu)
    }
}
