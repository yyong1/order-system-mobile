package com.example.foodorder.data.trash

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.foodorder.data.utils.DrawableListConverter

@Entity(tableName = "popularData")
data class PopularData(
    @PrimaryKey(autoGenerate = true)
    val resId: Int,
    val title: String,
    val price: Double,
    val rate: Double,
    val description: String,
    val calories: Double,
    val scheduleTime: Double,
    @TypeConverters(DrawableListConverter::class)
    val ingredients: List<Int>
)
