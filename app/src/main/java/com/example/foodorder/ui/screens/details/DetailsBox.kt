package com.example.foodorder.ui.screens.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.foodorder.R
import com.example.foodorder.data.models.PopularData
import com.example.foodorder.ui.theme.BlackTextColor
import com.example.foodorder.ui.theme.CardItemBg
import com.example.foodorder.ui.theme.DividerColor
import com.example.foodorder.ui.theme.Typography

@Composable
fun DetailBox(data: PopularData) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
            .clip(RoundedCornerShape(14.dp))
            .background(
                CardItemBg
            )
            .padding(15.dp)
    )
    {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {


            Row {
                Image(
                    painter = painterResource(id = R.drawable.calori),
                    contentDescription = "Calorie",
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = "${data.calories} kcal",
                    style = Typography.body2,
                    color = BlackTextColor
                )
            }

            Divider(
                color = DividerColor, modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp)
            )


            Row {
                Image(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = "Star",
                    modifier = Modifier.size(20.dp)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = "${data.rate}",
                    style = Typography.body2,
                    color = BlackTextColor
                )
            }

            Divider(
                color = DividerColor, modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp)
            )

            Row {

                Image(
                    painter = painterResource(id = R.drawable.schedule),
                    contentDescription = "Schedule",
                    modifier = Modifier.size(20.dp)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = "${data.scheduleTime} Min",
                    style = Typography.body2,
                    color = BlackTextColor
                )
            }

        }
    }
}