package com.example.foodorder.ui.screens.homepage.popular

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.foodorder.ui.theme.*
import com.example.foodorder.R
import com.example.foodorder.data.models.CartItem
import com.example.foodorder.data.models.Menu
import com.example.foodorder.data.viewmodels.CartViewModel

@Composable
fun PopularItem(
    popularData: Menu,
    navController: NavController,
    cartViewModel: CartViewModel,
    onPopularDataClick: (Menu) -> Unit
) {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(176.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(176.dp)
                    .padding(end = 13.dp)
                    .clip(RoundedCornerShape(18.dp))
                    .clickable {
                        navController.navigate("details/${popularData.menuId}")
                    }
                    .background(CardItemBg)
            ) {
                Column(
                    modifier = Modifier.padding(start = 20.dp, top = 20.dp)
                ) {
                    Box(modifier = Modifier.height(40.dp), contentAlignment = Alignment.Center) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(id = R.drawable.crown),
                                contentDescription = stringResource(R.string.crown),
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

                    Box(modifier = Modifier.height(40.dp), contentAlignment = Alignment.Center) {
                        Text(
                            text = popularData.title,
                            style = Typography.body1,
                            fontSize = 18.sp,
                            color = BlackTextColor
                        )
                    }

                    Box(modifier = Modifier.height(40.dp), contentAlignment = Alignment.Center) {
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
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomStart),
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(width = 60.dp, height = 40.dp)
                                .clip(RoundedCornerShape(bottomStart = 18.dp, topEnd = 18.dp))
                                .background(Yellow500)
                                .clickable {
                                    val cartItem = CartItem(
                                        id = 0, // Use 0 for auto-generated ID
                                        menuItemId = popularData.menuId,
                                        menuItemName = popularData.title,
                                        menuItemPrice = popularData.price,
                                        quantity = 1
                                    )
                                    cartViewModel.addCartItem(cartItem)
                                },
                            contentAlignment = Alignment.Center
                        ) {
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
                        .align(Alignment.CenterEnd)
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
    }
}
