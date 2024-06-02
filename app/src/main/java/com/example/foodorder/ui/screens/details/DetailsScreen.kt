package com.example.foodorder.ui.screens.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.foodorder.R
import com.example.foodorder.data.viewmodels.MenuViewModel
import com.example.foodorder.ui.components.common.BoxWithRes
import com.example.foodorder.ui.theme.*


@Composable
fun DetailsScreen(navController: NavController, menuId: Int, menuViewModel: MenuViewModel) {
    val menus by menuViewModel.allMenus.collectAsState(initial = emptyList())
    val menuItem = menus.find { it.menuId == menuId }

    menuItem?.let { data ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            DetailHeader(navController = navController)

            Spacer(modifier = Modifier.height(32.dp))

            Image(
                painter = painterResource(id = data.resId),
                contentDescription = "",
                modifier = Modifier.size(275.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
            ) {
                Column(verticalArrangement = Arrangement.SpaceBetween) {
                    Text(
                        text = data.title,
                        style = Typography.body1,
                        fontSize = 22.sp,
                        color = BlackTextColor
                    )

                    Box(
                        modifier = Modifier.height(40.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "$",
                                style = Typography.body1,
                                fontSize = 14.sp,
                                color = Orange500
                            )

                            Text(
                                text = "${data.price}",
                                style = Typography.body1,
                                fontSize = 20.sp,
                                color = BlackTextColor
                            )
                        }
                    }
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    BoxWithRes(
                        resId = R.drawable.minus,
                        description = "Minus",
                        iconSize = 16,
                        boxSize = 36,
                        iconColor = BlackTextColor
                    )

                    Spacer(modifier = Modifier.width(14.dp))

                    Text(
                        text = "01",
                        style = Typography.body2,
                        fontSize = 18.sp,
                        color = BlackTextColor
                    )

                    Spacer(modifier = Modifier.width(14.dp))

                    BoxWithRes(
                        resId = R.drawable.add,
                        description = "Add",
                        iconSize = 16,
                        boxSize = 36,
                        iconColor = Color.White,
                        bgColor = Yellow500
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            data.description?.let {
                Text(
                    text = it,
                    style = Typography.h5,
                    fontSize = 16.sp,
                    color = TextColor,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            DetailBox(data = data)

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Ingredients",
                style = Typography.body1,
                fontSize = 22.sp,
                color = BlackTextColor,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                items(data.ingredients.size) { index ->
                    Box(
                        modifier = Modifier
                            .size(56.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(CardItemBg),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = data.ingredients[index]),
                            contentDescription = "",
                            modifier = Modifier.size(width = 30.dp, height = 24.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Box(
                modifier = Modifier
                    .size(width = 203.dp, height = 56.dp)
                    .clip(RoundedCornerShape(topStart = 18.dp, topEnd = 18.dp))
                    .background(Yellow500),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Add to cart", style = Typography.body1, color = Color.White)
            }
        }
    }
}