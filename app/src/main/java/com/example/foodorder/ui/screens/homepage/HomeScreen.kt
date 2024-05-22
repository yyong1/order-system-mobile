package com.example.foodorder.ui.screens.homepage

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.foodorder.data.trash.PopularData
import com.example.foodorder.data.trash.PopularDataViewModel
import com.example.foodorder.data.viewmodels.CategoryViewModel
import com.example.foodorder.ui.screens.homepage.header.Header
import com.example.foodorder.ui.screens.homepage.ordernow.OrderNowBox
import com.example.foodorder.ui.screens.homepage.categories.CategoryList
import kotlinx.coroutines.launch
import com.example.foodorder.R
import com.example.foodorder.ui.screens.homepage.popular.PopularList
import com.example.foodorder.ui.theme.BlackTextColor
import com.example.foodorder.ui.theme.Typography


@Composable
fun HomeScreen(
    navController: NavHostController,
    popularDataViewModel: PopularDataViewModel,
    categoryViewModel: CategoryViewModel,
    onPopularDataClick: (PopularData) -> Unit
) {
    val scrollState = rememberScrollState()
    val scope = rememberCoroutineScope()
    val popList = listOf(
        PopularData(
            resId = R.drawable.salad_pesto_pizza,
            title = "Salad Pesto Pizza",
            description = "There are many variations of smth smth smth smth smth --- ...",
            price = 10.55,
            calories = 540.0,
            scheduleTime = 20.0,
            rate = 5.0,
            ingredients = listOf(
                R.drawable.ing1,
                R.drawable.ing2,
                R.drawable.ing3,
                R.drawable.ing4,
                R.drawable.ing5,
            )
        ),
        PopularData(
            resId = R.drawable.primavera_pizza,
            title = "Primavera Pizza",
            description = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form.",
            price = 12.55,
            calories = 440.0,
            scheduleTime = 30.0,
            rate = 4.5,
            ingredients = listOf(
                R.drawable.ing1,
                R.drawable.ing2,
                R.drawable.ing3,
                R.drawable.ing4,
                R.drawable.ing5,
            )
        )
    )

    val categoryList = categoryViewModel.allCategories.collectAsState().value

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
            CategoryList(categories = categoryList)
            Spacer(modifier = Modifier.height(20.dp))
            SectionTitle(title = "Popular Items")
            Spacer(modifier = Modifier.height(20.dp))
            PopularList(
                popularList = popList,
                navController = navController,
                onPopularDataClick = onPopularDataClick
            )
        }
    }

    DisposableEffect(Unit) {
        val job = scope.launch {
            val convertedList = popList.map { popularData ->
                PopularData(
                    resId = popularData.resId,
                    title = popularData.title,
                    price = popularData.price,
                    rate = popularData.rate,
                    description = popularData.description,
                    calories = popularData.calories,
                    scheduleTime = popularData.scheduleTime,
                    ingredients = popularData.ingredients
                )
            }
            popularDataViewModel.savePopularData(convertedList)
        }

        onDispose {
            job.cancel()
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
