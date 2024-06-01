package com.example.foodorder

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.example.foodorder.data.AppDatabase
import com.example.foodorder.data.repository.*
import com.example.foodorder.data.trash.PopularDataRepository
import com.example.foodorder.ui.theme.FoodOrderTheme
import com.example.foodorder.data.trash.PopularDataViewModel
import com.example.foodorder.data.trash.PopularDataViewModelFactory
import com.example.foodorder.data.viewmodels.*
import com.example.foodorder.ui.screens.MainScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private lateinit var userViewModel: UserViewModel
    private lateinit var popularDataViewModel: PopularDataViewModel
    private lateinit var categoryViewModel: CategoryViewModel
    private lateinit var orderViewModel: OrderViewModel
    private lateinit var cartViewModel: CartViewModel // Add CartViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "onCreate triggered")

        val database = AppDatabase.getInstance(this)

        val popularDataDao = database.popularDataDao()
        val popularDataRepository = PopularDataRepository(popularDataDao)
        val popularDataViewModelFactory = PopularDataViewModelFactory(popularDataRepository)
        popularDataViewModel = ViewModelProvider(this, popularDataViewModelFactory)[PopularDataViewModel::class.java]

        val userDao = database.userDao()
        val userRepository = UserRepository(userDao)
        val userViewModelFactory = UserViewModelFactory(userRepository)
        userViewModel = ViewModelProvider(this, userViewModelFactory)[UserViewModel::class.java]

        val categoryDao = database.categoryDao()
        val categoryRepository = CategoryRepository(categoryDao)
        val categoryViewModelFactory = CategoryViewModelFactory(categoryRepository)
        categoryViewModel = ViewModelProvider(this, categoryViewModelFactory)[CategoryViewModel::class.java]

        val orderDao = database.orderDao()
        val orderRepository = OrderRepository(orderDao)
        val orderViewModelFactory = OrderViewModelFactory(orderRepository)
        orderViewModel = ViewModelProvider(this, orderViewModelFactory)[OrderViewModel::class.java]

        val cartDao = database.cartDao()
        val cartRepository = CartRepository(cartDao)
        val cartViewModelFactory = CartViewModelFactory(cartRepository)
        cartViewModel = ViewModelProvider(this, cartViewModelFactory)[CartViewModel::class.java]


        setContent {
            FoodOrderTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val navController = rememberNavController()
                    MainScreen(
                        navController = navController,
                        userViewModel = userViewModel,
                        popularDataViewModel = popularDataViewModel,
                        categoryViewModel = categoryViewModel,
                        orderViewModel = orderViewModel,
                        cartViewModel = cartViewModel
                    )
                }
            }
        }

        // Recreate and populate the database
        CoroutineScope(Dispatchers.IO).launch {
            recreateAndPopulateDatabase(database)
        }
    }

    private suspend fun recreateAndPopulateDatabase(database: AppDatabase) {
        AppDatabase.clearAllTables(database)
        AppDatabase.populateDatabase(database)
    }
}

