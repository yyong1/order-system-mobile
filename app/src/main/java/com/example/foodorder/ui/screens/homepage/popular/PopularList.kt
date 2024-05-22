package com.example.foodorder.ui.screens.homepage.popular

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.foodorder.data.trash.PopularData

@Composable
fun PopularList(
    popularList: List<PopularData>,
    navController: NavController,
    onPopularDataClick: (PopularData) -> Unit
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
