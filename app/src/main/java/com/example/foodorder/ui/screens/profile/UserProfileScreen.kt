package com.example.foodorder.ui.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.foodorder.R
import com.example.foodorder.data.models.User
import com.example.foodorder.data.viewmodels.OrderViewModel
import com.example.foodorder.data.viewmodels.UserViewModel
import com.example.foodorder.ui.components.*
import kotlinx.coroutines.launch

@Composable
fun UserProfileScreen(userViewModel: UserViewModel, orderViewModel: OrderViewModel) {
    val coroutineScope = rememberCoroutineScope()
    var user by remember { mutableStateOf<User?>(null) }
    var isEditing by remember { mutableStateOf(false) }
    val orders by orderViewModel.orders.collectAsState(initial = emptyList())

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            user = userViewModel.getUserById(userId = 1)
            orderViewModel.fetchAllOrders()
        }
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        user?.let {
            // Static Avatar with hardcoded image
            Image(
                painter = painterResource(id = R.drawable.avatar_icon),
                contentDescription = "User Avatar",
                modifier = Modifier.size(100.dp).align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(16.dp))

            if (isEditing) {
                UserProfileUpdateForm(user = it, onUpdate = { updatedUser ->
                    coroutineScope.launch {
                        userViewModel.updateUser(
                            updatedUser.id ?: 0,
                            updatedUser.name,
                            updatedUser.email,
                            updatedUser.favoriteRestaurant
                        )
                        user = userViewModel.getUserById(updatedUser.id ?: 0)
                        isEditing = false
                    }
                })
            } else {
                UserProfileDetails(user = it, onEdit = { isEditing = true })
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Order History", style = MaterialTheme.typography.h6)
            FilterOptions { startDate, endDate ->
                coroutineScope.launch {
                    orderViewModel.fetchOrders(userId = it.id ?: 0, startDate, endDate)
                }
            }
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(orders) { order ->
                    OrderItem(order)
                }
            }
        }
    }
}
