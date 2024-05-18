package com.example.foodorder.ui.screens.login.form

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.foodorder.ui.screens.login.field.DemoField
import com.example.foodorder.ui.screens.login.ErrorMessages

@Composable
fun LoginField(
    userEmail: String,
    password: String,
    onUsernameChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onForgotPasswordClick: () -> Unit,
    errorMessage: ErrorMessages
) {
    Column {
        DemoField(
            value = userEmail,
            label = "Email",
            placeholder = "Enter your email address",
            onValueChange = onUsernameChange,
            error = errorMessage.userEmail,
            leadingIcon = {
                Icon(Icons.Default.Email, contentDescription = "email")
            }
        )
        Spacer(modifier = Modifier.height(2.dp))
        DemoField(
            value = password,
            label = "Password",
            placeholder = "Enter your password",
            onValueChange = onPasswordChange,
            visualTransformation = PasswordVisualTransformation(),
            error = errorMessage.password,
            leadingIcon = {
                Icon(Icons.Default.Lock, contentDescription = "pass")
            }
        )
        TextButton(onClick = onForgotPasswordClick, modifier = Modifier.align(Alignment.End)) {
            Text(text = "Forgot password")
        }
    }
}
