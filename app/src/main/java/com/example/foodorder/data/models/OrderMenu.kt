package com.example.foodorder.data.models

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    primaryKeys = ["orderId", "menuId"],
    foreignKeys = [
        ForeignKey(entity = Order::class, parentColumns = ["orderId"], childColumns = ["orderId"]),
        ForeignKey(entity = Menu::class, parentColumns = ["menuId"], childColumns = ["menuId"])
    ]
)
data class OrderMenu(
    val orderId: Int,
    val menuId: Int,
    val quantity: Int
)
