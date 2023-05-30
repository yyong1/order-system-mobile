package com.example.foodorder.ui.navigation

sealed class ScreensRoutes(val route: String) {
    object Home : ScreensRoutes("home")
    object Login : ScreensRoutes("login")
    object Registration : ScreensRoutes("registration")
}