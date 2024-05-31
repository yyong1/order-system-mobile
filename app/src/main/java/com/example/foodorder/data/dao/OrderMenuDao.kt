package com.example.foodorder.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.foodorder.data.models.Order
import com.example.foodorder.data.models.OrderMenu

@Dao
interface OrderMenuDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(orderMenu: List<OrderMenu>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(orderMenu: OrderMenu)

    @Query("SELECT * FROM ordermenu WHERE orderId = :orderId AND menuId = :menuId")
    suspend fun getOrderMenuById(orderId: Int, menuId: Int): OrderMenu?

    @Query("SELECT * FROM ordermenu")
    suspend fun getAllOrderMenus(): List<OrderMenu>
}