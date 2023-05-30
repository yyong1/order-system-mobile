package com.example.foodorder

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.foodorder.ui.navigation.Navigation
import com.example.foodorder.ui.theme.FoodOrderTheme

@Composable
fun FoodOrderApp() {
    val navController = rememberNavController()

    FoodOrderTheme {
        Surface {
            Navigation(navController = navController)
        }
    }
}