package com.example.foodorder.data.repository;

import com.example.foodorder.data.dao.OrderDao;
import com.example.foodorder.data.models.Order;

class OrderRepository(private val orderDao: OrderDao) {
    suspend fun saveOrder(order: Order) {
        orderDao.insert(order)
    }

    suspend fun getAllOrders():List<Order>

    {
        return orderDao.getAllOrders()
    }

    suspend fun getOrderById(orderId: Int): Order? {
        return orderDao.getOrderById(orderId)
    }
}
