package com.example.foodorder.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "restaurants")
data class Restaurant(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val locationLatitude: Double,
    val locationLongitude: Double,
    val isPopular: Boolean = false
)
