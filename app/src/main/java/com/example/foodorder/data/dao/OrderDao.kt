package com.example.foodorder.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.foodorder.data.models.Order

@Dao
interface OrderDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(order: Order)

    @Query("SELECT * FROM `Order` WHERE orderId = :orderId")
    suspend fun getOrderById(orderId: Int): Order?

    @Query("SELECT * FROM `Order`")
    suspend fun getAllOrders(): List<Order>
}
