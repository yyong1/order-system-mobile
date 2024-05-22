package com.example.foodorder.ui.components.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun BottomNavBar(
    items: List<BottomNavItem>,
    onItemClick: (BottomNavItem) -> Unit
) {
    BottomNavigation {
        items.forEach { item ->
            BottomNavigationItem(
                icon = { /* icon */ },
                label = { Text(item.name) },
                selected = false, // selection logic
                onClick = { onItemClick(item) }
            )
        }
    }
}

data class BottomNavItem(
    val name: String,
    val route: String
)
