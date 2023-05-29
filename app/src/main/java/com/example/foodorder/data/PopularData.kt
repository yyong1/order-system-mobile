package com.example.foodorder.data

import androidx.annotation.DrawableRes

data class PopularData(
    @DrawableRes
    val resId: Int,
    val title: String,
    val price: Double,
    val rate: Double,
    val description: String,
    val calories: Double,
    val scheduleTime: Double,
    val ingredients: List<Int>
)
