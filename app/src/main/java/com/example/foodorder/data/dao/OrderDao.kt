package com.example.foodorder.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.foodorder.data.models.Order
import com.example.foodorder.data.models.OrderMenu
import java.util.Date

@Dao
interface OrderDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(orders: List<Order>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(order: Order)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrderMenu(orderMenu: OrderMenu)

    @Query("SELECT * FROM `orders` WHERE orderId = :orderId")
    suspend fun getOrderById(orderId: Int): Order?

    @Query("SELECT * FROM `orders`")
    suspend fun getAllOrders(): List<Order>

    @Query("SELECT * FROM `orders` WHERE userId = :userId AND orderDate BETWEEN :startDate AND :endDate ORDER BY orderDate DESC")
    suspend fun getOrdersByDateRange(userId: Int, startDate: Date, endDate: Date): List<Order>

    @Query("SELECT * FROM `orders` WHERE userId = :userId ORDER BY orderDate DESC LIMIT 1")
    suspend fun getLastOrder(userId: Int): Order?
}
