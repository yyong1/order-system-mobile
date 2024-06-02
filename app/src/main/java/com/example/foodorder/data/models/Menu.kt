package com.example.foodorder.data.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.foodorder.data.utils.DrawableListConverter

@Entity(
    tableName = "menus",
    foreignKeys = [
        ForeignKey(entity = Restaurant::class, parentColumns = ["id"], childColumns = ["restaurantId"]),
        ForeignKey(entity = Category::class, parentColumns = ["categoryId"], childColumns = ["categoryId"])
    ]
)
data class Menu(
    @PrimaryKey(autoGenerate = true)
    val menuId: Int = 0,
    val restaurantId: Int,
    val resId: Int,
    val title: String,
    val description: String?,
    val price: Double,
    val rate: Double,
    val calories: Double,
    val scheduleTime: Double,
    val categoryId: Int?,
    @TypeConverters(DrawableListConverter::class)
    val ingredients: List<Int>,
    val isPopular: Boolean = false
)
