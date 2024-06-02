package com.example.foodorder.data.repository

import com.example.foodorder.data.dao.CartDao
import com.example.foodorder.data.models.CartItem
import kotlinx.coroutines.flow.Flow

class CartRepository(private val cartDao: CartDao) {
    fun getAllCartItems(): Flow<List<CartItem>> = cartDao.getAllCartItems()

    suspend fun insertCartItem(cartItem: CartItem) = cartDao.insertCartItem(cartItem)

    suspend fun updateCartItem(cartItem: CartItem) = cartDao.updateCartItem(cartItem)

    suspend fun deleteCartItem(cartItem: CartItem) = cartDao.deleteCartItem(cartItem)

    suspend fun clearCart() = cartDao.clearCart()
}
