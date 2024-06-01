package com.example.foodorder.data.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodorder.data.models.CartItem
import com.example.foodorder.data.repository.CartRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class CartViewModel(private val cartRepository: CartRepository) : ViewModel() {
    val cartItems: StateFlow<List<CartItem>> = cartRepository.getAllCartItems()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun addCartItem(cartItem: CartItem) {
        viewModelScope.launch {
            cartRepository.insertCartItem(cartItem)
        }
    }

    fun updateCartItem(cartItem: CartItem) {
        viewModelScope.launch {
            cartRepository.updateCartItem(cartItem)
        }
    }

    fun removeCartItem(cartItem: CartItem) {
        viewModelScope.launch {
            cartRepository.deleteCartItem(cartItem)
        }
    }

    fun clearCart() {
        viewModelScope.launch {
            cartRepository.clearCart()
        }
    }
}
