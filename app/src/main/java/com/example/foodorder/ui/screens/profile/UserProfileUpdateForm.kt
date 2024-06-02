package com.example.foodorder.ui.screens.profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.foodorder.data.models.User

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun UserProfileUpdateForm(user: User, onUpdate: (User) -> Unit) {
    var name by remember { mutableStateOf(user.name) }
    var email by remember { mutableStateOf(user.email) }
    var favoriteRestaurant by remember { mutableStateOf(user.favoriteRestaurant) }

    // Focus requesters for each TextField
    val (nameFocusRequester, emailFocusRequester, restaurantFocusRequester) = FocusRequester.createRefs()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(nameFocusRequester)
                .padding(bottom = 8.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(emailFocusRequester)
                .padding(bottom = 8.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        TextField(
            value = favoriteRestaurant,
            onValueChange = { favoriteRestaurant = it },
            label = { Text("Favorite Restaurant") },
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(restaurantFocusRequester)
                .padding(bottom = 8.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
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
            Text(text = "Submit")
        }
    }
}
