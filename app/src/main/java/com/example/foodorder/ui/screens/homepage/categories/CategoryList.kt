package com.example.foodorder.ui.screens.homepage.categories

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.foodorder.data.models.Category

@Composable
fun CategoryList(categories: List<Category>) {
    val selectedIndex = remember { mutableStateOf(0) }

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        items(categories.size) { index ->
            CategoryItem(
                category = categories[index],
                selectedIndex = selectedIndex,
                index = index
            )
        }
    }
}
