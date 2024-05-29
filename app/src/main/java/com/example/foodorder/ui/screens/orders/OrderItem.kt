package com.example.foodorder.ui.screens.orders

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
            // Mocked order details for simplicity, replace with real data
            Column(modifier = Modifier.padding(start = 16.dp)) {
                Text(text = "Order details go here")
            }
        }
        Divider()
    }
}
