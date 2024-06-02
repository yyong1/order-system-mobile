package com.example.foodorder.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.foodorder.data.models.User

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
