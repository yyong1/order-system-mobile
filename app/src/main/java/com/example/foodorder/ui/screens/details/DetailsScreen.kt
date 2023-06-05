package com.example.foodorder.ui.screens.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.foodorder.ui.screens.homepage.BoxWithRes
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.foodorder.ui.theme.BlackTextColor
import com.example.foodorder.ui.theme.CardItemBg
import com.example.foodorder.ui.theme.Orange500
import com.example.foodorder.ui.theme.TextColor
import com.example.foodorder.ui.theme.Typography
import com.example.foodorder.ui.theme.Yellow500
import com.example.foodorder.R

@Composable
fun DetailsScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(start = 30.dp, top = 48.dp, end = 30.dp)
    )
    {

        val data = navController.previousBackStackEntry?.arguments?.getParcelable<PopularData>(Destinations.DetailArgs.foodData)

        if (data != null) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(
                        rememberScrollState()
                    )
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
                )
                {
                    Column(verticalArrangement = Arrangement.SpaceBetween) {

                        Text(
                            text = data.title, style = Typography.body1,
                            fontSize = 22.sp,
                            color = BlackTextColor
                        )

                        Box(
                            modifier = Modifier
                                .height(40.dp),
                            contentAlignment = Alignment.Center
                        )
                        {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
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

                Text(
                    text = data.description,
                    style = Typography.h5,
                    fontSize = 16.sp,
                    color = TextColor,
                    modifier = Modifier.fillMaxWidth()
                )

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
                )
                {
                    items(data.ingradients.size) { index ->
                        Box(
                            modifier = Modifier
                                .size(56.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(
                                    CardItemBg
                                ), contentAlignment = Alignment.Center
                        )
                        {
                            Image(
                                painter = painterResource(id = data.ingradients[index]),
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
                        .background(
                            Yellow500
                        ), contentAlignment = Alignment.Center
                )
                {
                    Text(text = "Add to card", style = Typography.body1, color = Color.White)
                }

            }

        }
    }
}