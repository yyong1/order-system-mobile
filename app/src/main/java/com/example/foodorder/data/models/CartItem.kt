package com.example.foodorder.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart_items")
data class CartItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val menuItemId: Int,
    val menuItemName: String,
    val menuItemPrice: Double,
    val quantity: Int
)
