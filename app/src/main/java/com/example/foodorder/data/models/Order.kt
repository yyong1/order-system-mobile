package com.example.foodorder.data.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "Order",
    foreignKeys = [
        ForeignKey(entity = User::class, parentColumns = ["id"], childColumns = ["userId"]),
        ForeignKey(entity = Restaurant::class, parentColumns = ["id"], childColumns = ["restaurantId"])
    ]
)
data class Order(
    @PrimaryKey(autoGenerate = true)
    val orderId: Int = 0,
    val userId: Int,
    val restaurantId: Int,
    val orderDate: String,
    val totalPrice: Double
)
