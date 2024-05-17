package com.example.foodorder.ui.screens.register.form

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.foodorder.ui.screens.register.ErrorMessages
import com.example.foodorder.ui.screens.register.field.DemoField

@Composable
fun RegField(
    userName: String,
    userEmail: String,
    password: String,
    confirmPassword: String,
    onUserNameChange: (String) -> Unit,
    onUserEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onConfirmPasswordChange: (String) -> Unit,
    errorMessage: ErrorMessages
) {
    Column {
        DemoField(
            value = userName,
            label = "UserName",
            placeholder = "Enter your name",
            onValueChange = onUserNameChange,
            error = errorMessage.userName,
            leadingIcon = {
                Icon(Icons.Default.AccountBox, contentDescription = "name")
            }
        )
        Spacer(modifier = Modifier.height(2.dp))
        DemoField(
            value = userEmail,
            label = "Email",
            placeholder = "Enter your email address",
            onValueChange = onUserEmailChange,
            error= errorMessage.userEmail,
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
            error= errorMessage.password,
            leadingIcon = {
                Icon(Icons.Default.Lock, contentDescription = "pass")
            }
        )
        Spacer(modifier = Modifier.height(2.dp))
        DemoField(
            value = confirmPassword,
            label = "Repeat Password",
            placeholder = "Repeat your password",
            onValueChange = onConfirmPasswordChange,
            visualTransformation = PasswordVisualTransformation(),
            error= errorMessage.confirmPassword,
            leadingIcon = {
                Icon(Icons.Default.Lock, contentDescription = "pass")
            }
        )
    }
}
