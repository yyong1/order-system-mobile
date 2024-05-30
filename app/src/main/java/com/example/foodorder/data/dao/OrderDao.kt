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
    suspend fun insertAll(order: List<Order>)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(order: Order)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrderMenu(orderMenu: OrderMenu)

    @Query("SELECT * FROM `Order` WHERE orderId = :orderId")
    suspend fun getOrderById(orderId: Int): Order?

    @Query("SELECT * FROM `Order`")
    suspend fun getAllOrders(): List<Order>

    @Query("SELECT * FROM `Order` WHERE userId = :userId AND orderDate BETWEEN :startDate AND :endDate ORDER BY orderDate DESC")
    fun getOrdersByDateRange(userId: Int, startDate: Date, endDate: Date): List<Order>

    @Query("SELECT * FROM `Order` WHERE userId = :userId ORDER BY orderDate DESC LIMIT 1")
    fun getLastOrder(userId: Int): Order?
}
