package com.example.foodorder.ui.screens.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.foodorder.R
import com.example.foodorder.data.models.CartItem
import com.example.foodorder.data.viewmodels.CartViewModel
import com.example.foodorder.data.viewmodels.MenuViewModel
import com.example.foodorder.ui.theme.Orange500

@Composable
fun CartItemRow(
    cartItem: CartItem,
    menuViewModel: MenuViewModel,
    onUpdateQuantity: (CartItem) -> Unit,
    onRemoveItem: () -> Unit
) {
    var quantity by remember { mutableStateOf(cartItem.quantity) }
    val menuItem by menuViewModel.getMenuById(cartItem.menuItemId).collectAsState(initial = null)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        menuItem?.let { menu ->
            Image(
                painter = painterResource(id = menu.resId),
                contentDescription = "Product Image",
                modifier = Modifier.size(40.dp)
            )
        } ?: run {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.LightGray),
                contentAlignment = Alignment.Center
            ) {
                Text("?", style = MaterialTheme.typography.h6, color = Color.White)
            }
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(text = cartItem.menuItemName, style = MaterialTheme.typography.body1)
            Text(text = "Price: $${cartItem.menuItemPrice}", style = MaterialTheme.typography.body2)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Quantity: ", style = MaterialTheme.typography.body2)

                IconButton(
                    onClick = {
                        if (quantity > 1) {
                            quantity--
                            onUpdateQuantity(cartItem.copy(quantity = quantity))
                        }
                    },
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape)
                        .background(Color.Gray)
                ) {
                    Text(text = "-", color = Color.White)
                }

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "$quantity",
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))

                IconButton(
                    onClick = {
                        quantity++
                        onUpdateQuantity(cartItem.copy(quantity = quantity))
                    },
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape)
                        .background(Color.Gray)
                ) {
                    Text(text = "+", color = Color.White)
                }
            }
        }
        IconButton(onClick = onRemoveItem) {
            Icon(imageVector = Icons.Default.Delete, contentDescription = "Remove")
        }
    }
}
