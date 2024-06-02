package com.example.foodorder.ui.screens.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.Image
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
import com.example.foodorder.data.models.Order
import com.example.foodorder.data.viewmodels.CartViewModel
import com.example.foodorder.data.viewmodels.MenuViewModel
import com.example.foodorder.data.viewmodels.OrderViewModel
import com.example.foodorder.ui.theme.Orange500
import kotlinx.coroutines.launch
import java.util.Date

@Composable
fun CartScreen(
    cartViewModel: CartViewModel,
    menuViewModel: MenuViewModel,
    orderViewModel: OrderViewModel,
    navController: NavHostController
) {
    val cartItems by cartViewModel.cartItems.collectAsState()
    var showCheckoutDialog by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(Orange500)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Go Back",
                    tint = Color.Black
                )
            }

            Text(
                text = "Cart",
                style = MaterialTheme.typography.h4,
                modifier = Modifier
                    .weight(1f)
                    .wrapContentWidth(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.width(48.dp)) // To balance the row alignment
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (cartItems.isEmpty()) {
            EmptyCart()
        } else {
            LazyColumn(modifier = Modifier.weight(1f)) {
                items(cartItems) { cartItem ->
                    CartItemRow(
                        cartItem = cartItem,
                        menuViewModel = menuViewModel,
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

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { cartViewModel.clearCart() },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text(text = "Clear Cart")
                }

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = { showCheckoutDialog = true },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text(text = "Checkout")
                }
            }
        }
    }

    if (showCheckoutDialog) {
        CheckoutDialog(
            cartItems = cartItems,
            onConfirm = {
                coroutineScope.launch {
                    val newOrder = Order(
                        userId = 1, // Fetch from user's session or profile
                        restaurantId = 1, // Fetch based on the cart items or user's choice
                        orderDate = Date().toString(),
                        totalPrice = cartItems.sumOf { it.menuItemPrice * it.quantity }
                    )
                    orderViewModel.saveOrder(newOrder)
                    cartViewModel.clearCart()
                    showCheckoutDialog = false
                }
            },
            onDismiss = { showCheckoutDialog = false }
        )
    }
}

@Composable
fun CheckoutDialog(cartItems: List<CartItem>, onConfirm: () -> Unit, onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = "Confirm Checkout") },
        text = {
            Column {
                Text(text = "Review your cart items:")
                cartItems.forEach { cartItem ->
                    Text(text = "${cartItem.quantity} x ${cartItem.menuItemName} - $${cartItem.menuItemPrice}")
                }
                Text(text = "Total: $${cartItems.sumOf { it.menuItemPrice * it.quantity }}")
            }
        },
        confirmButton = {
            Button(onClick = onConfirm) {
                Text(text = "Confirm")
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text(text = "Cancel")
            }
        }
    )
}

@Composable
fun EmptyCart() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.idk_avatar_icon),
            contentDescription = "Empty Cart",
            modifier = Modifier.size(120.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Your cart is empty", style = MaterialTheme.typography.h6)
    }
}
