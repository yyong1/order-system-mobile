package com.example.foodorder.ui.screens.homepage

import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.foodorder.data.models.CategoryData
import com.example.foodorder.data.models.PopularData
import com.example.foodorder.ui.theme.BlackTextColor
import com.example.foodorder.ui.theme.CardItemBg
import com.example.foodorder.ui.theme.IconColor
import com.example.foodorder.ui.theme.Orange500
import com.example.foodorder.ui.theme.TextColor
import com.example.foodorder.ui.theme.Typography
import com.example.foodorder.ui.theme.Yellow500
import com.example.foodorder.R
import com.example.foodorder.ui.navigation.ScreensRoutes
import com.example.foodorder.ui.screens.homepage.header.Header
import com.example.foodorder.ui.screens.homepage.ordernow.OrderNowBox
import com.example.foodorder.ui.theme.FoodOrderTheme

@Composable
fun HomeScreen(navController: NavHostController) {

    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 30.dp, top = 48.dp, end = 17.dp)
    ) {
        Column(modifier = Modifier.verticalScroll(state = scrollState)) {
            Header()

            Spacer(modifier = Modifier.height(32.dp))

            OrderNowBox()

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "Categories",
                style = Typography.body1,
                fontSize = 22.sp,
                color = BlackTextColor
            )

            Spacer(modifier = Modifier.height(20.dp))

            CategoryList(
                categories = listOf(
                    CategoryData(redId = R.drawable.pizza, title = "Pizza"),
                    CategoryData(redId = R.drawable.hamburger, title = "Burger"),
                    CategoryData(redId = R.drawable.drinks, title = "Drinks"),
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Categories",
                style = Typography.body1,
                fontSize = 22.sp,
                color = BlackTextColor
            )

            Spacer(modifier = Modifier.height(20.dp))

            // TODO: put in the db
            PopularList(
                popularList = listOf(
                    PopularData(
                        R.drawable.salad_pesto_pizza,
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
                        R.drawable.primavera_pizza,
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
                ), navController = navController
            )
        }
    }
}

@Composable
fun BoxWithRes(
    resId: Int,
    description: String,
    bgColor: Color? = CardItemBg,
    iconColor: Color? = IconColor,
    boxSize: Int? = 40,
    iconSize: Int = 24,
    navController: NavController? = null
) {
    Box(
        modifier = Modifier
            .size(boxSize!!.dp)
            .clip(RoundedCornerShape(10.dp))
            .clickable {
                navController?.popBackStack()
            }
            .background(bgColor!!), contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = resId),
            contentDescription = description,
            modifier = Modifier.size(iconSize.dp),
            tint = iconColor!!
        )
    }
}

@Composable
fun CategoryList(categories: List<CategoryData>) {

    val selectedIndex = remember {
        mutableStateOf(0)
    }

    LazyRow(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        items(categories.size) { index ->
            CategoryItem(
                categoryData = categories[index], selectedIndex = selectedIndex, index = index
            )
        }
    }
}

@Composable
fun CategoryItem(categoryData: CategoryData, selectedIndex: MutableState<Int>, index: Int) {
    Box(
        modifier = Modifier
            .size(width = 106.dp, height = 146.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable {
                selectedIndex.value = index
            }
            .background(
                if (selectedIndex.value == index) Yellow500 else CardItemBg
            )
            .clickable { selectedIndex.value = index }, contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                painter = painterResource(id = categoryData.redId),
                contentDescription = categoryData.title,
                modifier = Modifier.size(48.dp),
                tint = if (selectedIndex.value == index) Color.White else BlackTextColor
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = categoryData.title,
                style = Typography.body2,
                fontSize = 18.sp,
                color = if (selectedIndex.value == index) Color.White else BlackTextColor
            )
        }
    }
}

@Composable
fun PopularList(popularList: List<PopularData>, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        for (item in popularList) {
            PopularItem(popularData = item, navController = navController)
        }
    }
}

@Composable
fun PopularItem(popularData: PopularData, navController: NavController) {

    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(176.dp)
        )
        {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(176.dp)
                    .padding(end = 13.dp)
                    .clip(RoundedCornerShape(18.dp))
                    .clickable {
                        navController.currentBackStackEntry?.arguments = Bundle().apply {
                            putParcelable(Destinations.DetailArgs.foodData, popularData)
                        }
                        navController.navigate(ScreensRoutes.Details.route)
                    }
                    .background(
                        CardItemBg
                    )
            )

            Column(
                modifier = Modifier
                    .padding(start = 20.dp, top = 20.dp)
            ) {
                Box(modifier = Modifier.height(40.dp), contentAlignment = Alignment.Center)
                {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.crown),
                            contentDescription = "Crown",
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(11.dp))

                        Text(
                            text = "Best Selling",
                            style = Typography.h5,
                            fontSize = 14.sp,
                            color = TextColor
                        )
                    }
                }

                Box(modifier = Modifier.height(40.dp), contentAlignment = Alignment.Center)
                {
                    Text(
                        text = popularData.title,
                        style = Typography.body1,
                        fontSize = 18.sp,
                        color = BlackTextColor
                    )
                }

                Box(modifier = Modifier.height(40.dp), contentAlignment = Alignment.Center)
                {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "$",
                            style = Typography.body1,
                            fontSize = 14.sp,
                            color = Orange500
                        )

                        Text(
                            text = "${popularData.price}",
                            style = Typography.body1,
                            fontSize = 20.sp,
                            color = BlackTextColor
                        )
                    }
                }
            }


            Box(
                modifier =
                Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomStart),
            )
            {

                Row(verticalAlignment = Alignment.CenterVertically) {

                    Box(
                        modifier = Modifier
                            .size(width = 60.dp, height = 40.dp)
                            .clip(RoundedCornerShape(bottomStart = 18.dp, topEnd = 18.dp))
                            .background(Yellow500),
                        contentAlignment = Alignment.Center
                    )
                    {
                        Icon(
                            painter = painterResource(id = R.drawable.add),
                            contentDescription = "Add",
                            modifier = Modifier.size(24.dp),
                            tint = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.width(48.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = "Star",
                            modifier = Modifier.size(16.dp),
                            tint = BlackTextColor
                        )
                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = "${popularData.rate}",
                            style = Typography.body1,
                            color = BlackTextColor
                        )
                    }
                }
            }


            Image(
                painter = painterResource(id = popularData.resId),
                contentDescription = popularData.title,
                modifier = Modifier
                    .size(156.dp)
                    .align(
                        Alignment.CenterEnd
                    )
            )


        }

        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
@Preview
fun PreviewHomeScreen() {
    FoodOrderTheme {
        Surface {
//            HomeScreen()
        }
    }
}
