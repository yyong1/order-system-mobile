package com.example.foodorder.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.foodorder.data.trash.PopularDataViewModel
import com.example.foodorder.data.viewmodels.CartViewModel
import com.example.foodorder.data.viewmodels.CategoryViewModel
import com.example.foodorder.data.viewmodels.MenuViewModel
import com.example.foodorder.data.viewmodels.OrderViewModel
import com.example.foodorder.data.viewmodels.RestaurantViewModel
import com.example.foodorder.data.viewmodels.UserViewModel
import com.example.foodorder.ui.components.navigation.BottomNavBar
import com.example.foodorder.ui.components.navigation.BottomNavItem
import com.example.foodorder.ui.navigation.Navigation
import com.example.foodorder.ui.navigation.ScreensRoutes

@Composable
fun MainScreen(
    navController: NavHostController,
    userViewModel: UserViewModel,
    popularDataViewModel: PopularDataViewModel,
    categoryViewModel: CategoryViewModel,
    orderViewModel: OrderViewModel,
    cartViewModel: CartViewModel,
    menuViewModel: MenuViewModel,
    restaurantViewModel: RestaurantViewModel,
) {
    val bottomNavItems = listOf(
        BottomNavItem("Home", ScreensRoutes.Home.route, Icons.Default.Home),
        BottomNavItem("Map", ScreensRoutes.Map.route, Icons.Default.LocationOn),
        BottomNavItem("Profile", ScreensRoutes.Profile.route, Icons.Default.Person)
    )

    var currentRoute by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(navController) {
        navController.currentBackStackEntryFlow.collect { backStackEntry ->
            currentRoute = backStackEntry.destination.route
            Log.d("CurrentRoute MainScreen", "Current Route: $currentRoute")
        }
    }

    Scaffold(
        bottomBar = {
            if (currentRoute in listOf(ScreensRoutes.Home.route, ScreensRoutes.Map.route, ScreensRoutes.Profile.route)) {
                BottomNavBar(items = bottomNavItems, navController = navController, currentRoute = currentRoute)
            }
        }
    ) { innerPadding ->
        Navigation(
            navController = navController,
            userViewModel = userViewModel,
            popularDataViewModel = popularDataViewModel,
            categoryViewModel = categoryViewModel,
            orderViewModel = orderViewModel,
            cartViewModel = cartViewModel,
            menuViewModel = menuViewModel,
            restaurantViewModel = restaurantViewModel,
            modifier = Modifier.padding(innerPadding)
        )
    }
}
