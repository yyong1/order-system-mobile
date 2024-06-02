package com.example.foodorder.ui.screens.homepage.popular

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.foodorder.data.models.Menu
import com.example.foodorder.data.viewmodels.CartViewModel

@Composable
fun PopularList(
    popularList: List<Menu>,
    navController: NavController,
    cartViewModel: CartViewModel,
    onPopularDataClick: (Menu) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        for (item in popularList) {
            PopularItem(
                popularData = item,
                navController = navController,
                cartViewModel = cartViewModel,
                onPopularDataClick = onPopularDataClick
            )
        }
    }
}