package com.example.foodorder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodorder.ui.theme.*


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodOrderTheme {
                // A surface container using the 'background' color from the theme
            }
        }
    }
}
@Composable
fun HomeScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 30.dp, top = 48.dp, end = 17.dp)
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            BoxWithRes(resId = R.drawable.menu, description = "Menu")
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.location),
                    contentDescription = "Location",
                    modifier = Modifier.size(16.dp),
                    tint = Orange500
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "California, US") // Should be dynamic rendering
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    painter = painterResource(id = R.drawable.arrow_down),
                    contentDescription = "Down",
                    modifier = Modifier.size(16.dp),
                    tint = Orange500
                )
            }
            BoxWithRes(resId = R.drawable.search, description = "Search")
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
    iconSize: Int = 24
){
    Box(
        modifier = Modifier
            .size(boxSize!!.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(bgColor!!),
        contentAlignment = Alignment.Center
    ){
        Icon(
            painter = painterResource(id = resId),
            contentDescription = description,
            modifier = Modifier.size(iconSize.dp),
            tint = iconColor!!
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FoodOrderTheme {
        HomeScreen()
    }
}