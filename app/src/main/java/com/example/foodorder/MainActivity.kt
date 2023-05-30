package com.example.foodorder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodorder.data.models.CategoryData
import com.example.foodorder.data.models.PopularData
import com.example.foodorder.ui.theme.BlackTextColor
import com.example.foodorder.ui.theme.CardItemBg
import com.example.foodorder.ui.theme.FoodOrderTheme
import com.example.foodorder.ui.theme.IconColor
import com.example.foodorder.ui.theme.Orange500
import com.example.foodorder.ui.theme.TextColor
import com.example.foodorder.ui.theme.Typography
import com.example.foodorder.ui.theme.Yellow200
import com.example.foodorder.ui.theme.Yellow500


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodOrderTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize()) {
                    FoodOrderApp()
                }
            }
        }
    }
}
//
//@Composable
//fun HomeScreen() {
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(start = 30.dp, top = 48.dp, end = 17.dp)
//    ) {
//        Column {
//            Header()
//
//            Spacer(modifier = Modifier.height(32.dp))
//
//            OrderNowBox()
//
//            Spacer(modifier = Modifier.height(30.dp))
//
//            Text(
//                text = "Categories",
//                style = Typography.body1,
//                fontSize = 22.sp,
//                color = BlackTextColor
//            )
//
//            Spacer(modifier = Modifier.height(20.dp))
//
//            CategoryList(
//                categories = listOf(
//                    CategoryData(redId = R.drawable.pizza, title = "Pizza"),
//                    CategoryData(redId = R.drawable.hamburger, title = "Burger"),
//                    CategoryData(redId = R.drawable.drinks, title = "Drinks"),
//                )
//            )
//
//            Spacer(modifier = Modifier.height(20.dp))
//
//            Text(
//                text = "Categories",
//                style = Typography.body1,
//                fontSize = 22.sp,
//                color = BlackTextColor
//            )
//
//            Spacer(modifier = Modifier.height(20.dp))
//
//            // error in this part
//            PopularList(
//                popularList = listOf(
//                    PopularData(
//                        R.drawable.salad_pesto_pizza,
//                        title = "Salad Pesto Pizza",
//                        description = "There are many variations of smth smth smth smth smth --- ...",
//                        price = 10.55,
//                        calories = 540.0,
//                        scheduleTime = 20.0,
//                        rate = 5.0,
//                        ingredients = listOf(
//                            R.drawable.ing1,
//                            R.drawable.ing2,
//                            R.drawable.ing3,
//                            R.drawable.ing4,
//                            R.drawable.ing5,
//                        )
//                    )
//                )
//            )
//        }
//    }
//}
//
//@Composable
//fun OrderNowBox() {
//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(156.dp)
//            .clip(RoundedCornerShape(10.dp))
//            .background(Yellow200)
//            .padding(24.dp)
//    ) {
//        Row(
//            horizontalArrangement = Arrangement.SpaceBetween,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Column(verticalArrangement = Arrangement.SpaceBetween) {
//                Text(buildAnnotatedString {
//                    withStyle(style = SpanStyle(color = BlackTextColor)) {
//                        append(stringResource(R.string.the_fastest_in)+"\n" + stringResource(R.string.delivery))
//                    }
//                    Spacer(modifier = Modifier.width(8.dp))
//                    withStyle(style = SpanStyle(color = Yellow500)) {
//                        append(stringResource(R.string.food))
//                    }
//                })
//                Box(
//                    modifier = Modifier
//                        .size(width = 126.dp, height = 40.dp)
//                        .clip(RoundedCornerShape(10.dp))
//                        .background(Yellow500),
//                    contentAlignment = Alignment.Center
//                ) {
//                    Text(
//                        text = stringResource(id = R.string.order_now),
//                        style = Typography.body1,
//                        fontWeight = FontWeight.SemiBold,
//                        color = Color.White,
//                        fontSize = 14.sp
//                    )
//                }
//            }
//            Image(
//                painter = painterResource(id = R.drawable.deliveryman),
//                contentDescription = "Deliveryman",
//                modifier = Modifier.size(156.dp)
//            )
//        }
//    }
//}
//
//@Composable
//fun Header() {
//    Row(
//        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.SpaceBetween,
//        modifier = Modifier.fillMaxWidth()
//    ) {
//        BoxWithRes(resId = R.drawable.menu, description = "Menu")
//        Row(verticalAlignment = Alignment.CenterVertically) {
//            Icon(
//                painter = painterResource(id = R.drawable.location),
//                contentDescription = "Location",
//                modifier = Modifier.size(16.dp),
//                tint = Orange500
//            )
//            Spacer(modifier = Modifier.width(8.dp))
//
//            // Should be dynamic rendering
//
//            Text(text = "California, US")
//            Spacer(modifier = Modifier.width(8.dp))
//            Icon(
//                painter = painterResource(id = R.drawable.arrow_down),
//                contentDescription = "Down",
//                modifier = Modifier.size(16.dp),
//                tint = Orange500
//            )
//        }
//        BoxWithRes(resId = R.drawable.search, description = "Search")
//    }
//}
//
//@Composable
//fun BoxWithRes(
//    resId: Int,
//    description: String,
//    bgColor: Color? = CardItemBg,
//    iconColor: Color? = IconColor,
//    boxSize: Int? = 40,
//    iconSize: Int = 24
//) {
//    Box(
//        modifier = Modifier
//            .size(boxSize!!.dp)
//            .clip(RoundedCornerShape(10.dp))
//            .background(bgColor!!), contentAlignment = Alignment.Center
//    ) {
//        Icon(
//            painter = painterResource(id = resId),
//            contentDescription = description,
//            modifier = Modifier.size(iconSize.dp),
//            tint = iconColor!!
//        )
//    }
//}
//
//@Composable
//fun CategoryList(categories: List<CategoryData>) {
//
//    val selectedIndex = remember {
//        mutableStateOf(0)
//    }
//
//    LazyRow(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
//        items(categories.size) { index ->
//            CategoryItem(
//                categoryData = categories[index], selectedIndex = selectedIndex, index = index
//            )
//        }
//    }
//}
//
//@Composable
//fun CategoryItem(categoryData: CategoryData, selectedIndex: MutableState<Int>, index: Int) {
//    Box(
//        modifier = Modifier
//            .size(width = 106.dp, height = 146.dp)
//            .clip(RoundedCornerShape(16.dp))
//            .background(
//                if (selectedIndex.value == index) Yellow500 else CardItemBg
//            )
//            .clickable { selectedIndex.value = index }, contentAlignment = Alignment.Center
//    ) {
//        Column(horizontalAlignment = Alignment.CenterHorizontally) {
//            Icon(
//                painter = painterResource(id = categoryData.redId),
//                contentDescription = categoryData.title,
//                modifier = Modifier.size(48.dp),
//                tint = if (selectedIndex.value == index) Color.White else BlackTextColor
//            )
//            Spacer(modifier = Modifier.height(16.dp))
//            Text(
//                text = categoryData.title,
//                style = Typography.body2,
//                fontSize = 18.sp,
//                color = if (selectedIndex.value == index) Color.White else BlackTextColor
//            )
//        }
//    }
//}
//
//@Composable
//fun PopularList(popularList: List<PopularData>) {
//    LazyColumn(modifier = Modifier.fillMaxWidth()) {
//        items(popularList.size) { index ->
//            PopularItem(popularData = popularList[index])
//        }
//    }
//}
//
//@Composable
//fun PopularItem(popularData: PopularData?) {
//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(176.dp)
//            .padding(start = 24.dp, top = 20.dp)
//    ) {
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(176.dp)
//                .padding(end = 13.dp)
//                .clip(RoundedCornerShape(18.dp))
//                .background(CardItemBg)
//        )
//
//        Column(modifier = Modifier.padding(start = 20.dp, top = 20.dp)) {
//
//            Box(modifier = Modifier.height(40.dp), contentAlignment = Alignment.Center)
//            {
//                Row(verticalAlignment = Alignment.CenterVertically) {
//                    Image(
//                        painter = painterResource(id = R.drawable.crown),
//                        contentDescription = "Crown",
//                        modifier = Modifier.size(24.dp)
//                    )
//                    Spacer(modifier = Modifier.width(11.dp))
//
//                    Text(
//                        text = "Best Selling",
//                        style = Typography.h5,
//                        fontSize = 14.sp,
//                        color = TextColor
//                    )
//                }
//            }
//            Box(modifier = Modifier.height(40.dp), contentAlignment = Alignment.Center)
//            {
//                if (popularData != null) {
//                    Text(
//                        text = popularData.title,
//                        style = Typography.body1,
//                        fontSize = 18.sp,
//                        color = BlackTextColor
//                    )
//                }
//            }
//            Box(modifier = Modifier.height(40.dp), contentAlignment = Alignment.Center)
//            {
//                Row(verticalAlignment = Alignment.CenterVertically) {
//                    Text(
//                        text = "$", style = Typography.body1, fontSize = 14.sp, color = Orange500
//                    )
//                    Text(
//                        text = "10.55",
//                        style = Typography.body1,
//                        fontSize = 20.sp,
//                        color = BlackTextColor
//                    )
//                }
//            }
//        }
//
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .align(Alignment.BottomStart),
//        )
//        {
//            Row(verticalAlignment = Alignment.CenterVertically) {
//                Box(
//                    modifier = Modifier
//                        .size(width = 60.dp, height = 40.dp)
//                        .clip(RoundedCornerShape(bottomStart = 18.dp, topEnd = 18.dp))
//                        .background(Yellow500),
//                    contentAlignment = Alignment.Center
//                ) {
//                    Icon(
//                        painter = painterResource(id = R.drawable.add),
//                        contentDescription = "Add",
//                        modifier = Modifier.size(24.dp),
//                        tint = Color.White
//                    )
//                }
//
//                Spacer(modifier = Modifier.width(48.dp))
//
//                // dop feature maybe delete later
//                Row(verticalAlignment = Alignment.CenterVertically) {
//                    Icon(
//                        painter = painterResource(id = R.drawable.star),
//                        contentDescription = "star",
//                        modifier = Modifier.size(16.dp),
//                        tint = BlackTextColor
//                    )
//
//                    Spacer(modifier = Modifier.width(48.dp))
//
//                    Text(text = "5.0", style = Typography.body1, color = BlackTextColor)
//                }
//            }
//        }
//
//        Image(
//            painter = painterResource(id = R.drawable.salad_pesto_pizza),
//            contentDescription = "Food photo",
//            modifier = Modifier
//                .size(156.dp)
//                .align(
//                    Alignment.CenterEnd
//                )
//        )
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    FoodOrderTheme {
//        HomeScreen()
//    }
//}