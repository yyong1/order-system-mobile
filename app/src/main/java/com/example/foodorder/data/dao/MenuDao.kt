package com.example.foodorder.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.foodorder.data.models.Menu
import kotlinx.coroutines.flow.Flow

@Dao
interface MenuDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(menu: List<Menu>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(menu: Menu)

    @Query("SELECT * FROM menus WHERE menuId = :menuId")
    suspend fun getMenuById(menuId: Int): Menu?

    @Query("SELECT * FROM menus")
    fun getAllMenus(): Flow<List<Menu>>

    @Query("SELECT * FROM menus WHERE restaurantId = :restaurantId")
    fun getMenusByRestaurantId(restaurantId: Int): Flow<List<Menu>>
}
