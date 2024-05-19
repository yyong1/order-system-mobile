package com.example.foodorder.data.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.foodorder.data.models.Order
import com.example.foodorder.data.repository.OrderRepository
import kotlinx.coroutines.launch

class OrderViewModel(private val orderRepository: OrderRepository) : ViewModel() {

    suspend fun saveOrder(order: Order) {
        viewModelScope.launch {
            orderRepository.saveOrder(order)
        }
    }

    suspend fun getAllOrders(): List<Order> {
        return orderRepository.getAllOrders()
    }

    suspend fun getOrderById(orderId: Int): Order? {
        return orderRepository.getOrderById(orderId)
    }
}


