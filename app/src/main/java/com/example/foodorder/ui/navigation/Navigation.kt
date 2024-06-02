package com.example.foodorder.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.NavType
import com.example.foodorder.ui.screens.details.DetailsScreen
import com.example.foodorder.ui.screens.homepage.HomeScreen
import com.example.foodorder.ui.screens.log.LoginScreen
import com.example.foodorder.ui.screens.map.MapScreen
import com.example.foodorder.ui.screens.reg.RegistrationScreen
import com.example.foodorder.data.trash.PopularDataViewModel
import com.example.foodorder.data.viewmodels.CartViewModel
import com.example.foodorder.data.viewmodels.UserViewModel
import com.example.foodorder.data.viewmodels.CategoryViewModel
import com.example.foodorder.data.viewmodels.MenuViewModel
import com.example.foodorder.data.viewmodels.OrderViewModel
import com.example.foodorder.data.repository.MenuRepository
import com.example.foodorder.ui.screens.cart.CartScreen
import com.example.foodorder.ui.screens.profile.UserProfileScreen

@Composable
fun Navigation(
    navController: NavHostController,
    userViewModel: UserViewModel,
    popularDataViewModel: PopularDataViewModel,
    categoryViewModel: CategoryViewModel,
    orderViewModel: OrderViewModel,
    cartViewModel: CartViewModel,
    menuViewModel: MenuViewModel,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = ScreensRoutes.Login.route,
        modifier = modifier
    ) {
        composable(ScreensRoutes.Home.route) {
            HomeScreen(navController = navController, menuViewModel = menuViewModel, categoryViewModel = categoryViewModel, onPopularDataClick = {
                navController.navigate("details/${it.menuId}")
            })
        }
        composable(ScreensRoutes.Login.route) {
            LoginScreen(navController = navController, userViewModel = userViewModel)
        }
        composable(ScreensRoutes.Registration.route) {
            RegistrationScreen(navController = navController, userViewModel = userViewModel)
        }
        composable(
            "details/{menuId}",
            arguments = listOf(navArgument("menuId") { type = NavType.IntType })
        ) { backStackEntry ->
            val menuId = backStackEntry.arguments?.getInt("menuId")
            menuId?.let { DetailsScreen(navController = navController, menuId = it, menuViewModel = menuViewModel) }
        }
        composable(ScreensRoutes.Map.route) {
            MapScreen()
        }
        composable(ScreensRoutes.Profile.route) {
            UserProfileScreen(userViewModel = userViewModel, orderViewModel = orderViewModel)
        }
        composable(ScreensRoutes.Cart.route) {
            CartScreen(cartViewModel = cartViewModel, navController = navController)
        }
    }
}
