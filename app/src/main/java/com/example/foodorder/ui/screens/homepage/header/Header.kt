package com.example.foodorder.ui.screens.homepage.header

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.foodorder.R
import com.example.foodorder.ui.components.common.BoxWithRes
import com.example.foodorder.ui.navigation.ScreensRoutes
import com.example.foodorder.ui.theme.Orange500

@Composable
fun Header(navController: NavHostController) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Icon(
            imageVector = Icons.Default.ShoppingCart,
            contentDescription = "Shopping Cart",
            modifier = Modifier
                .clickable { navController.navigate(ScreensRoutes.Cart.route) }
                .size(24.dp),
            tint = Color.Black
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.location),
                contentDescription = "Location",
                modifier = Modifier.size(16.dp),
                tint = Orange500
            )
            Spacer(modifier = Modifier.width(8.dp))

            Text(text = "Sarajevo, BiH")
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                painter = painterResource(id = R.drawable.arrow_down),
                contentDescription = "Down",
                modifier = Modifier.size(16.dp),
                tint = Orange500
            )
        }
        BoxWithRes(resId = R.drawable.search, description = "Search", onClick = {
//            if (quantity > 1) quantity--
        })
    }
}
