package com.example.foodorder.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.foodorder.data.dao.*
import com.example.foodorder.data.models.*
import com.example.foodorder.data.trash.*
import com.example.foodorder.data.utils.DrawableListConverter


@Database(
    entities = [
        User::class,
        PopularData::class,
        Category::class,
        Menu::class,
        Restaurant::class,
        Order::class,
        OrderMenu::class
    ],
    version = 2, // Increment this version number
    exportSchema = false
)
@TypeConverters(DrawableListConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun popularDataDao(): PopularDataDao
    abstract fun categoryDao(): CategoryDao
    abstract fun menuDao(): MenuDao
    abstract fun restaurantDao(): RestaurantDao
    abstract fun orderDao(): OrderDao
    abstract fun orderMenuDao(): OrderMenuDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .fallbackToDestructiveMigration() // Use this to recreate the database on schema changes
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}