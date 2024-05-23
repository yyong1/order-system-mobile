package com.example.foodorder.ui.components.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController

@Composable
fun BottomNavBar(
    items: List<BottomNavItem>,
    navController: NavHostController,
    currentRoute: String?
) {
    BottomNavigation {
        items.forEach { item ->
            BottomNavigationItem(
                icon = { item.icon?.let { Icon(it, contentDescription = item.name) } },
                label = { Text(item.name) },
                selected = currentRoute == item.route,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                }
            )
        }
    }
}

data class BottomNavItem(
    val name: String,
    val route: String,
    val icon: ImageVector? = null
)
