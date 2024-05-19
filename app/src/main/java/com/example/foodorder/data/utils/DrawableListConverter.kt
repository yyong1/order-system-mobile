package com.example.foodorder.data.utils

import androidx.room.TypeConverter

class DrawableListConverter {
    @TypeConverter
    fun fromDrawableList(drawableList: List<Int>): String {
        return drawableList.joinToString(",")
    }

    @TypeConverter
    fun toDrawableList(drawableListString: String): List<Int> {
        return drawableListString.split(",").map { it.toInt() }
    }
}
