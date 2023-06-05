package com.example.foodorder.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.foodorder.ui.screens.details.DetailsScreen
import com.example.foodorder.ui.screens.homepage.*
import com.example.foodorder.ui.screens.log.LoginScreen
import com.example.foodorder.ui.screens.reg.RegistrationScreen
import com.example.foodorder.ui.viewmodels.UserViewModel

@Composable
fun Navigation(navController: NavHostController, userViewModel: UserViewModel) {

    NavHost(navController = navController, startDestination = ScreensRoutes.Login.route) {
        composable(ScreensRoutes.Home.route) {
            HomeScreen(
                navController
            )
        }
        composable(ScreensRoutes.Login.route) {
            LoginScreen(
                navController = navController,
                userViewModel = userViewModel
            )
        }
        composable(ScreensRoutes.Registration.route) {
            RegistrationScreen(
                navController = navController,
                userViewModel = userViewModel
            )
        }
        composable(ScreensRoutes.Details.route) {
            DetailsScreen(navController = navController)
        }
    }
}


