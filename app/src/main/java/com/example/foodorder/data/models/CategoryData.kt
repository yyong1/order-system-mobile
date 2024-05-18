package com.example.foodorder.data.models

import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categoryData")
data class CategoryData(
    @PrimaryKey
    val redId: Int,
    val title: String
)
