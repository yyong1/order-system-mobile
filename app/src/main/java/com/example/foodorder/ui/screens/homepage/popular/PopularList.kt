package com.example.foodorder.ui.screens.homepage.popular

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.foodorder.data.models.Menu

@Composable
fun PopularList(
    popularList: List<Menu>,
    navController: NavController,
    onPopularDataClick: (Menu) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        for (item in popularList) {
            PopularItem(
                popularData = item,
                navController = navController,
                onPopularDataClick = onPopularDataClick
            )
        }
    }
}