package com.example.foodorder.data.database

import android.content.Context
import androidx.room.Room

object AppDatabaseProvider {
    private var appDatabase: AppDatabase? = null

    fun getDatabase(context: Context): AppDatabase {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "food_order_database"
            ).build()
        }
        return appDatabase as AppDatabase
    }
}

// usage:
// val userDao = AppDatabaseProvider.getDatabase(context).userDao()
// val foodDao = AppDatabaseProvider.getDatabase(context).foodDao()
// val cartItemDao = AppDatabaseProvider.getDatabase(context).cartItemDao()