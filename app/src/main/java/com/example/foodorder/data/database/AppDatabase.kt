package com.example.foodorder.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.foodorder.data.dao.CategoryDataDao
import com.example.foodorder.data.dao.PopularDataDao
import com.example.foodorder.data.dao.UserDao
import com.example.foodorder.data.models.CategoryData
import com.example.foodorder.data.models.PopularData
import com.example.foodorder.data.models.User

@Database(entities = [User::class, CategoryData::class, PopularData::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun popularDataDao(): PopularDataDao
    abstract fun categoryDataDao(): CategoryDataDao
}