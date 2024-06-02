package com.example.foodorder.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
data class Category(
    @PrimaryKey(autoGenerate = true)
    val categoryId: Int = 0,
    val name: String,
    val iconResId: Int
){
    fun isEmpty(): Boolean {
        return name.isEmpty()
    }
}
