package com.example.foodorder.data

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.foodorder.data.dao.CartDao
import com.example.foodorder.data.dao.CategoryDao
import com.example.foodorder.data.dao.MenuDao
import com.example.foodorder.data.dao.OrderDao
import com.example.foodorder.data.dao.OrderMenuDao
import com.example.foodorder.data.dao.RestaurantDao
import com.example.foodorder.data.dao.UserDao
import com.example.foodorder.data.models.CartItem
import com.example.foodorder.data.models.Category
import com.example.foodorder.data.models.Menu
import com.example.foodorder.data.models.Order
import com.example.foodorder.data.models.OrderMenu
import com.example.foodorder.data.models.Restaurant
import com.example.foodorder.data.models.User
import com.example.foodorder.data.sample.SampleData
import com.example.foodorder.data.trash.PopularData
import com.example.foodorder.data.trash.PopularDataDao
import com.example.foodorder.data.utils.DateTypeConverter
import com.example.foodorder.data.utils.DrawableListConverter
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
        OrderMenu::class,
        CartItem::class
    ],
    version = 8,
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
    abstract fun cartDao(): CartDao



    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Log.d("AppDatabase", "Database instance created")
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(AppDatabaseCallback())
                    .build()
                INSTANCE = instance
                instance
            }
        }

        private class AppDatabaseCallback : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                Log.d("AppDatabase", "Database onCreate callback triggered")
                INSTANCE?.let { database ->
                    CoroutineScope(Dispatchers.IO).launch {
                        populateDatabase(database)
                    }
                }
            }

            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                Log.d("AppDatabase", "Database onOpen callback triggered")
            }
        }

        suspend fun clearAllTables(database: AppDatabase) {
            database.clearAllTables()
            Log.d("AppDatabase", "All tables cleared")
        }

        suspend fun populateDatabase(database: AppDatabase) {
            val userDao = database.userDao()
            val categoryDao = database.categoryDao()
            val restaurantDao = database.restaurantDao()
            val menuDao = database.menuDao()
            val orderDao = database.orderDao()
            val orderMenuDao = database.orderMenuDao()
            Log.d("AppDatabase", "Populating database with sample data")

            try {
                Log.d("AppDatabase", "Inserting users")
                userDao.insertAll(SampleData.users)
                Log.d("AppDatabase", "Users inserted")

                Log.d("AppDatabase", "Inserting categories")
                categoryDao.insertAll(SampleData.categories)
                Log.d("AppDatabase", "Categories inserted")

                Log.d("AppDatabase", "Inserting restaurants")
                restaurantDao.insertAll(SampleData.restaurants)
                Log.d("AppDatabase", "Restaurants inserted")

                Log.d("AppDatabase", "Inserting menus")
                menuDao.insertAll(SampleData.menus)
                Log.d("AppDatabase", "Menus inserted")

                Log.d("AppDatabase", "Inserting orders")
                orderDao.insertAll(SampleData.orders)
                Log.d("AppDatabase", "Orders inserted")

                Log.d("AppDatabase", "Inserting order menus")
                orderMenuDao.insertAll(SampleData.orderMenus)
                Log.d("AppDatabase", "Order menus inserted")

                Log.d("AppDatabase", "Database population complete")
            } catch (e: Exception) {
                Log.e("AppDatabase", "Error populating database: ${e.message}")
                e.printStackTrace()
            }
        }
    }
}
