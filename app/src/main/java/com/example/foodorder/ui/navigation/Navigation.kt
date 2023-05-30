package com.example.foodorder.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.foodorder.ui.screens.homepage.HomeScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = ScreensRoutes.Home.route) {
        composable(ScreensRoutes.Home.route) {
            HomeScreen()
        }
    }
}