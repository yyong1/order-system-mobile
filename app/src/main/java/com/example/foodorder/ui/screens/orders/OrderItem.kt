package com.example.foodorder.ui.screens.orders

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.foodorder.data.models.Order

@Composable
fun OrderItem(order: Order) {
    var expanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "Restaurant: ${order.restaurantId}", style = MaterialTheme.typography.subtitle1)
            Text(text = "Total: $${order.totalPrice}", style = MaterialTheme.typography.subtitle1)
            IconButton(onClick = { expanded = !expanded }) {
                Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "Expand")
            }
        }
        if (expanded) {
            Column(modifier = Modifier.padding(start = 16.dp)) {
                Text(text = "Order details go here")
            }
        }
        Divider()
    }
}