package com.example.foodorder.ui.screens.profile

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.foodorder.data.models.User
import com.example.foodorder.data.viewmodels.OrderViewModel
import com.example.foodorder.data.viewmodels.UserViewModel
import com.example.foodorder.ui.screens.orders.OrderHistoryScreen
import kotlinx.coroutines.launch

@Composable
fun UserProfileScreen(userViewModel: UserViewModel, orderViewModel: OrderViewModel) {
    val coroutineScope = rememberCoroutineScope()
    var user by remember { mutableStateOf<User?>(null) }

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            user = userViewModel.getUserById(userId = 1) // Replace with actual user ID
        }
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        user?.let {
            UserInfoSection(user = it, onUpdate = { updatedUser ->
                coroutineScope.launch {
                    userViewModel.updateUser(
                        updatedUser.id ?: 0,
                        updatedUser.name,
                        updatedUser.email,
                        updatedUser.favoriteRestaurant
                    )
                    user = userViewModel.getUserById(updatedUser.id ?: 0) // Refresh user data
                }
            })
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Order History", style = MaterialTheme.typography.h6)
            OrderHistoryScreen(orderViewModel = orderViewModel)
        }
    }
}

@Composable
fun UserInfoSection(user: User, onUpdate: (User) -> Unit) {
    var name by remember { mutableStateOf(user.name) }
    var email by remember { mutableStateOf(user.email) }
    var favoriteRestaurant by remember { mutableStateOf(user.favoriteRestaurant) }

    Column(modifier = Modifier.fillMaxWidth()) {
        TextField(value = name, onValueChange = { name = it }, label = { Text("Name") })
        TextField(value = email, onValueChange = { email = it }, label = { Text("Email") })
        TextField(value = favoriteRestaurant, onValueChange = { favoriteRestaurant = it }, label = { Text("Favorite Restaurant") })
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            onUpdate(
                User(
                    id = user.id,
                    name = name,
                    email = email,
                    password = user.password,
                    favoriteRestaurant = favoriteRestaurant
                )
            )
        }) {
            Text(text = "Update Profile")
        }
    }
}
