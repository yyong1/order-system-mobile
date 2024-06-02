package com.example.foodorder.ui.screens.profile

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.foodorder.data.models.User

@Composable
fun UserProfileDetails(user: User, onEdit: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Name: ${user.name}", style = MaterialTheme.typography.body1)
        Text(text = "Email: ${user.email}", style = MaterialTheme.typography.body1)
        Text(text = "Favorite Restaurant: ${user.favoriteRestaurant}", style = MaterialTheme.typography.body1)
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = onEdit) {
            Text(text = "Update Profile")
        }
    }
}
