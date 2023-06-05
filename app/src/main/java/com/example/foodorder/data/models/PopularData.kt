package com.example.foodorder.data.models

import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "popularData")
data class PopularData(
//    @DrawableRes
    @PrimaryKey(autoGenerate = true)
    val resId: Int,
    val title: String,
    val price: Double,
    val rate: Double,
    val description: String,
    val calories: Double,
    val scheduleTime: Double,
    val ingredients: List<Int>
)
