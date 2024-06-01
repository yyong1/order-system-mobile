package com.example.foodorder.ui.navigation

sealed class ScreensRoutes(val route: String) {
    object Home : ScreensRoutes("home")
    object Details : ScreensRoutes("details")
    object Login : ScreensRoutes("login")
    object Registration : ScreensRoutes("registration")
    object Map : ScreensRoutes("map")
    object Orders : ScreensRoutes("orders")
    object Profile : ScreensRoutes("profile")
}
