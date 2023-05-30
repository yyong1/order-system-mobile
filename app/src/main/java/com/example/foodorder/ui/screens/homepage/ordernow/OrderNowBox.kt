package com.example.foodorder.ui.screens.homepage.ordernow

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodorder.R
import com.example.foodorder.ui.theme.BlackTextColor
import com.example.foodorder.ui.theme.Typography
import com.example.foodorder.ui.theme.Yellow200
import com.example.foodorder.ui.theme.Yellow500

@Composable
fun OrderNowBox() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(156.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Yellow200)
            .padding(24.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(verticalArrangement = Arrangement.SpaceBetween) {
                Text(buildAnnotatedString {
                    withStyle(style = SpanStyle(color = BlackTextColor)) {
                        append("The fastest in\n" + "Delivery")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    withStyle(style = SpanStyle(color = Yellow500)) {
                        append("Food")
                    }
                })
                Box(
                    modifier = Modifier
                        .size(width = 126.dp, height = 40.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Yellow500),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Order Now",
                        style = Typography.body1,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
                        fontSize = 14.sp
                    )
                }
            }
            Image(
                painter = painterResource(id = R.drawable.deliveryman),
                contentDescription = "Deliveryman",
                modifier = Modifier.size(156.dp)
            )
        }
    }
}