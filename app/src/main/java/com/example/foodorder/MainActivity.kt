package com.example.foodorder

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.example.foodorder.data.AppDatabase
import com.example.foodorder.data.repository.CartRepository
import com.example.foodorder.data.repository.CategoryRepository
import com.example.foodorder.data.repository.MenuRepository
import com.example.foodorder.data.repository.OrderRepository
import com.example.foodorder.data.repository.RestaurantRepository
import com.example.foodorder.data.repository.UserRepository
import com.example.foodorder.data.trash.PopularDataRepository
import com.example.foodorder.data.trash.PopularDataViewModel
import com.example.foodorder.data.trash.PopularDataViewModelFactory
import com.example.foodorder.data.viewmodels.CartViewModel
import com.example.foodorder.data.viewmodels.CartViewModelFactory
import com.example.foodorder.data.viewmodels.CategoryViewModel
import com.example.foodorder.data.viewmodels.CategoryViewModelFactory
import com.example.foodorder.data.viewmodels.MenuViewModel
import com.example.foodorder.data.viewmodels.MenuViewModelFactory
import com.example.foodorder.data.viewmodels.OrderViewModel
import com.example.foodorder.data.viewmodels.OrderViewModelFactory
import com.example.foodorder.data.viewmodels.RestaurantViewModel
import com.example.foodorder.data.viewmodels.RestaurantViewModelFactory
import com.example.foodorder.data.viewmodels.UserViewModel
import com.example.foodorder.data.viewmodels.UserViewModelFactory
import com.example.foodorder.ui.screens.MainScreen
import com.example.foodorder.ui.theme.FoodOrderTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private lateinit var userViewModel: UserViewModel
    private lateinit var popularDataViewModel: PopularDataViewModel
    private lateinit var categoryViewModel: CategoryViewModel
    private lateinit var orderViewModel: OrderViewModel
    private lateinit var cartViewModel: CartViewModel
    private lateinit var menuViewModel: MenuViewModel
    private lateinit var restaurantViewModel: RestaurantViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "onCreate triggered")


        val database = AppDatabase.getInstance(this)
        CoroutineScope(Dispatchers.IO).launch {
            recreateAndPopulateDatabase(database)
        }

        val popularDataDao = database.popularDataDao()
        val popularDataRepository = PopularDataRepository(popularDataDao)
        val popularDataViewModelFactory = PopularDataViewModelFactory(popularDataRepository)
        popularDataViewModel = ViewModelProvider(this, popularDataViewModelFactory)[PopularDataViewModel::class.java]

        val menuDao = database.menuDao()
        val menuRepository = MenuRepository(menuDao)
        val menuViewModelFactory = MenuViewModelFactory(menuRepository)
        menuViewModel = ViewModelProvider(this, menuViewModelFactory)[MenuViewModel::class.java]

        val userDao = database.userDao()
        val userRepository = UserRepository(userDao)
        val userViewModelFactory = UserViewModelFactory(userRepository)
        userViewModel = ViewModelProvider(this, userViewModelFactory)[UserViewModel::class.java]

        val categoryDao = database.categoryDao()
        val categoryRepository = CategoryRepository(categoryDao)
        val categoryViewModelFactory = CategoryViewModelFactory(categoryRepository)
        categoryViewModel = ViewModelProvider(this, categoryViewModelFactory)[CategoryViewModel::class.java]

        val restaurantDao = database.restaurantDao()
        val restaurantRepository = RestaurantRepository(restaurantDao)
        val restaurantViewModelFactory = RestaurantViewModelFactory(restaurantRepository)
        restaurantViewModel = ViewModelProvider(this, restaurantViewModelFactory)[RestaurantViewModel::class.java]

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
                        cartViewModel = cartViewModel,
                        menuViewModel = menuViewModel,
                        restaurantViewModel = restaurantViewModel
                    )
                }
            }
        }


    }

    private suspend fun recreateAndPopulateDatabase(database: AppDatabase) {
        AppDatabase.clearAllTables(database)
        AppDatabase.populateDatabase(database)
    }
}

