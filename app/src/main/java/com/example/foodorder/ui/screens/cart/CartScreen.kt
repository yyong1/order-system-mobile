package com.example.foodorder.ui.screens.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.foodorder.data.models.CartItem
import com.example.foodorder.data.viewmodels.CartViewModel

@Composable
fun CartScreen(cartViewModel: CartViewModel, navController: NavHostController) {
    val cartItems by cartViewModel.cartItems.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Go Back Arrow
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .align(Alignment.Start)
                .background(Color.Yellow)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Go Back",
                tint = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Cart", style = MaterialTheme.typography.h4)

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(cartItems) { cartItem ->
                CartItemRow(
                    cartItem = cartItem,
                    onUpdateQuantity = { updatedCartItem ->
                        cartViewModel.updateCartItem(updatedCartItem)
                    },
                    onRemoveItem = {
                        cartViewModel.removeCartItem(cartItem)
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { cartViewModel.clearCart() },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Clear Cart")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                // Handle checkout logic here
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Checkout")
        }
    }
}

@Composable
fun CartItemRow(cartItem: CartItem, onUpdateQuantity: (CartItem) -> Unit, onRemoveItem: () -> Unit) {
    var quantity by remember { mutableStateOf(cartItem.quantity) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(text = cartItem.menuItemName, style = MaterialTheme.typography.body1)
            Text(text = "Price: $${cartItem.menuItemPrice}", style = MaterialTheme.typography.body2)
            Row {
                Text(text = "Quantity: ")
                TextField(
                    value = quantity.toString(),
                    onValueChange = {
                        val newQuantity = it.toIntOrNull() ?: quantity
                        quantity = newQuantity
                        onUpdateQuantity(cartItem.copy(quantity = newQuantity))
                    },
                    modifier = Modifier.width(50.dp)
                )
            }
        }
        IconButton(onClick = onRemoveItem) {
            Icon(imageVector = Icons.Default.Delete, contentDescription = "Remove")
        }
    }
}
