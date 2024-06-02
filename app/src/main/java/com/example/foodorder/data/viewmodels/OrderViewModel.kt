package com.example.foodorder.data.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodorder.data.models.Order
import com.example.foodorder.data.repository.OrderRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.Date

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

    fun saveOrder(order: Order) {
        viewModelScope.launch {
            orderRepository.saveOrder(order)
        }
    }

    fun fetchAllOrders() {
        viewModelScope.launch {
            val allOrders = orderRepository.getAllOrders()
            Log.d("OrderViewModel", "Fetched all orders: $allOrders")
            _orders.value = allOrders
        }
    }

    fun getOrderById(orderId: Int) {
        viewModelScope.launch {
            val order = orderRepository.getOrderById(orderId)
            _orders.value = listOfNotNull(order)
        }
    }
}
