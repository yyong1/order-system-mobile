package com.example.foodorder.ui.screens.homepage

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.foodorder.data.models.Menu
import com.example.foodorder.data.viewmodels.CartViewModel
import com.example.foodorder.data.viewmodels.CategoryViewModel
import com.example.foodorder.data.viewmodels.MenuViewModel
import com.example.foodorder.ui.screens.homepage.header.Header
import com.example.foodorder.ui.screens.homepage.ordernow.OrderNowBox
import com.example.foodorder.ui.screens.homepage.categories.CategoryList
import com.example.foodorder.ui.screens.homepage.popular.PopularList
import com.example.foodorder.ui.theme.BlackTextColor
import com.example.foodorder.ui.theme.Typography

@Composable
fun HomeScreen(
    navController: NavHostController,
    menuViewModel: MenuViewModel,
    categoryViewModel: CategoryViewModel,
    cartViewModel: CartViewModel,
    onPopularDataClick: (Menu) -> Unit
) {
    val scrollState = rememberScrollState()
    val categories = categoryViewModel.allCategories.collectAsState().value
    val menus = menuViewModel.allMenus.collectAsState().value
    val popularMenus = menus.filter { it.isPopular }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 30.dp, top = 48.dp, end = 17.dp)
    ) {
        Column(modifier = Modifier.verticalScroll(state = scrollState)) {
            Header(navController)
            Spacer(modifier = Modifier.height(32.dp))
            OrderNowBox()
            Spacer(modifier = Modifier.height(30.dp))
            SectionTitle(title = "Categories")
            Spacer(modifier = Modifier.height(20.dp))
            CategoryList(categories = categories)
            Spacer(modifier = Modifier.height(20.dp))
            SectionTitle(title = "Popular Items")
            Spacer(modifier = Modifier.height(20.dp))
            PopularList(
                popularList = popularMenus,
                navController = navController,
                cartViewModel = cartViewModel,
                onPopularDataClick = onPopularDataClick
            )
        }
    }
}

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        style = Typography.body1,
        fontSize = 22.sp,
        color = BlackTextColor
    )
}
