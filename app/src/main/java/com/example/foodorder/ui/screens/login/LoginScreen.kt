package com.example.foodorder.ui.screens.login

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
import com.example.foodorder.data.viewmodels.UserViewModel
import com.example.foodorder.ui.navigation.ScreensRoutes
import com.example.foodorder.ui.screens.login.footer.LoginFooter
import com.example.foodorder.ui.screens.login.form.LoginField
import com.example.foodorder.ui.screens.login.header.LoginHeader
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(navController: NavHostController, userViewModel: UserViewModel) {
    Log.d("Navigation", "Navigating to LoginScreen")
    Login(navController = navController, userViewModel = userViewModel)
}

data class ErrorMessages(
    var userEmail: String = "",
    var password: String = "",
    var auth: String = "",
) {
    fun hasErrors(): Boolean {
        return userEmail.isNotEmpty() || password.isNotEmpty() || auth.isNotEmpty()
    }
}

@Composable
fun Login(navController: NavHostController, userViewModel: UserViewModel) {
    val scope = rememberCoroutineScope()
    var userEmail by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf(ErrorMessages()) }

    val userTest = User(
        name = "test",
        email = "test",
        password = "123",
        favoriteRestaurant = ""
    )

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.orange_bg),
            contentDescription = "Login bg",
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
            LoginHeader(error = errorMessage.auth)
            LoginField(
                userEmail,
                password,
                onUsernameChange = { userEmail = it },
                onPasswordChange = { password = it },
                onForgotPasswordClick = {
                    // nav
                },
                errorMessage = errorMessage
            )

            LoginFooter(
                onSignInClick = {
                    val newErrorMessage = ErrorMessages()
                    if (userEmail.isEmpty()) {
                        newErrorMessage.userEmail = "User email is required"
                    }
                    if (password.isEmpty()) {
                        newErrorMessage.password = "Password is required"
                    }

                    errorMessage = newErrorMessage

                    if (!newErrorMessage.hasErrors()) {
                        scope.launch {
                            if ((userTest.email == userEmail && userTest.password == password)
                                || userViewModel.checkUser(userEmail, password)
                            ) {
                                navController.navigate(ScreensRoutes.Home.route)
                            } else {
                                errorMessage = ErrorMessages(auth = "Wrong credentials")
                            }
                        }
                    }
                },
                onSignUpClick = {
                    navController.navigate(ScreensRoutes.Registration.route)
                }
            )
        }
    }
}

