package com.example.foodorder.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.foodorder.data.dao.*
import com.example.foodorder.data.models.*
import com.example.foodorder.data.sample.SampleData
import com.example.foodorder.data.trash.*
import com.example.foodorder.data.utils.DrawableListConverter
import com.example.foodorder.data.utils.DateTypeConverter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


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
@TypeConverters(DrawableListConverter::class, DateTypeConverter::class)
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
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
        private class AppDatabaseCallback : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                INSTANCE?.let { database ->
                    CoroutineScope(Dispatchers.IO).launch {
                        populateDatabase(database)
                    }
                }
            }
        }

        suspend fun populateDatabase(database: AppDatabase) {
            val categoryDao = database.categoryDao()
            val restaurantDao = database.restaurantDao()
            val menuDao = database.menuDao()
//        val userDao = database.userDao()
            val orderDao = database.orderDao()
            val orderMenuDao = database.orderMenuDao()

            categoryDao.insertAll(SampleData.categories)
            restaurantDao.insertAll(SampleData.restaurants)
            menuDao.insertAll(SampleData.menus)
//        userDao.insertAll(SampleData.users)
            orderDao.insertAll(SampleData.orders)
            orderMenuDao.insertAll(SampleData.orderMenus)
        }

    }
}