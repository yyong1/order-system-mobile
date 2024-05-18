package com.example.foodorder.ui.screens.register

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.foodorder.R
import com.example.foodorder.data.models.User
import com.example.foodorder.ui.navigation.ScreensRoutes
import com.example.foodorder.ui.screens.register.footer.RegFooter
import com.example.foodorder.ui.screens.register.form.RegField
import com.example.foodorder.ui.screens.register.header.RegHeader
import com.example.foodorder.ui.viewmodels.UserViewModel
import kotlinx.coroutines.launch

@Composable
fun RegistrationScreen(navController: NavHostController, userViewModel: UserViewModel) {
    Log.d("Navigation", "Navigating to RegistrationScreen")
    Registration(navController = navController, userViewModel = userViewModel)
}

data class ErrorMessages(
    var userName: String = "",
    var userEmail: String = "",
    var password: String = "",
    var confirmPassword: String = ""
) {
    fun hasErrors(): Boolean {
        return userName.isNotEmpty() || userEmail.isNotEmpty() || password.isNotEmpty() || confirmPassword.isNotEmpty()
    }
}

@Composable
fun Registration(navController: NavHostController, userViewModel: UserViewModel) {

    val scope = rememberCoroutineScope()

    var userName by remember { mutableStateOf("") }
    var userEmail by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf(ErrorMessages()) }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.orange_bg),
            contentDescription = "Reg bg",
            modifier = Modifier
                .fillMaxSize()
                .blur(6.dp),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .alpha(0.6f)
                .clip(CutCornerShape(topStart = 8.dp, topEnd = 16.dp, bottomStart = 16.dp))
                .background(Color.White)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(48.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            RegHeader()
            RegField(
                userName,
                userEmail,
                password,
                confirmPassword,
                onUserNameChange = { userName = it },
                onUserEmailChange = { userEmail = it },
                onPasswordChange = { password = it },
                onConfirmPasswordChange = { confirmPassword = it },
                errorMessage = errorMessage
            )

            RegFooter(
                onRegClick = {
                    val newErrorMessage = ErrorMessages()
                    if (userName.isEmpty()) {
                        newErrorMessage.userName = "User name is required"
                    }
                    if (userEmail.isEmpty()) {
                        newErrorMessage.userEmail = "User email is required"
                    }
                    if (password.isEmpty()) {
                        newErrorMessage.password = "Password is required"
                    }
                    if (confirmPassword.isEmpty()) {
                        newErrorMessage.confirmPassword = "Repeat the password"
                    }
                    if (confirmPassword != password) {
                        newErrorMessage.confirmPassword = "Passwords should match"
                    }

                    errorMessage = newErrorMessage

                    if (!newErrorMessage.hasErrors()) {
                        scope.launch {
                            val newUser =
                                User(name = userName, email = userEmail, password = password)
                            userViewModel.registerUser(newUser)
                            navController.navigate(ScreensRoutes.Home.route)
                        }
                    }
                },
                onLoginClick = {
                    navController.navigate(ScreensRoutes.Login.route)
                }
            )
        }
    }
}





