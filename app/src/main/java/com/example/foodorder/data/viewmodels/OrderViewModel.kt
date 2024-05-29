package com.example.foodorder.data.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodorder.data.models.Order
import com.example.foodorder.data.repository.OrderRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.*

class OrderViewModel(private val orderRepository: OrderRepository) : ViewModel() {

    private val _orders = MutableStateFlow<List<Order>>(emptyList())
    val orders: StateFlow<List<Order>> = _orders

    fun fetchOrders(userId: Int, startDate: Date, endDate: Date) {
        viewModelScope.launch {
            _orders.value = orderRepository.getOrdersByDateRange(userId, startDate, endDate)
        }
    }

    fun fetchLastOrder(userId: Int) {
        viewModelScope.launch {
            _orders.value = listOfNotNull(orderRepository.getLastOrder(userId))
        }
    }

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
