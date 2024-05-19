package com.example.foodorder.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.foodorder.data.models.Menu

@Dao
interface MenuDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(menu: Menu)

    @Query("SELECT * FROM menu WHERE menuId = :menuId")
    suspend fun getMenuById(menuId: Int): Menu?

    @Query("SELECT * FROM menu")
    suspend fun getAllMenus(): List<Menu>
}
