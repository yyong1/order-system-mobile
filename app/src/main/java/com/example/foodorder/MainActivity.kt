package com.example.foodorder

import android.content.Context
import android.os.Bundle
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
import com.example.foodorder.ui.navigation.Navigation
import com.example.foodorder.ui.theme.FoodOrderTheme
import com.example.foodorder.data.trash.PopularDataViewModel
import com.example.foodorder.data.trash.PopularDataViewModelFactory
import com.example.foodorder.data.viewmodels.*

class MainActivity : ComponentActivity() {
    private lateinit var userViewModel: UserViewModel
    private lateinit var popularDataViewModel: PopularDataViewModel
    private lateinit var categoryViewModel: CategoryViewModel
    private lateinit var orderViewModel: OrderViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        deleteDatabase(this)

        val popularDataDao = AppDatabase.getInstance(this).popularDataDao()
        val popularDataRepository = PopularDataRepository(popularDataDao)
        val popularDataViewModelFactory = PopularDataViewModelFactory(popularDataRepository)
        popularDataViewModel = ViewModelProvider(this, popularDataViewModelFactory)[PopularDataViewModel::class.java]

        val userDao = AppDatabase.getInstance(this).userDao()
        val userRepository = UserRepository(userDao)
        val userViewModelFactory = UserViewModelFactory(userRepository)
        userViewModel = ViewModelProvider(this, userViewModelFactory)[UserViewModel::class.java]

        val categoryDao = AppDatabase.getInstance(this).categoryDao()
        val categoryRepository = CategoryRepository(categoryDao)
        val categoryViewModelFactory = CategoryViewModelFactory(categoryRepository)
        categoryViewModel = ViewModelProvider(this, categoryViewModelFactory)[CategoryViewModel::class.java]

        val orderDao = AppDatabase.getInstance(this).orderDao()
        val orderRepository = OrderRepository(orderDao)
        val orderViewModelFactory = OrderViewModelFactory(orderRepository)
        orderViewModel = ViewModelProvider(this, orderViewModelFactory)[OrderViewModel::class.java]

        setContent {
            FoodOrderTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize()) {
                    val navController = rememberNavController()
                    Navigation(
                        navController = navController,
                        userViewModel = userViewModel,
                        popularDataViewModel = popularDataViewModel,
                        categoryViewModel = categoryViewModel,
                        orderViewModel = orderViewModel
                    )
                }
            }
        }
    }

    private fun deleteDatabase(context: Context) {
        context.deleteDatabase("app_database")
    }
}
