package com.example.foodorder.ui.screens.reg

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.foodorder.R
import com.example.foodorder.data.models.User
import com.example.foodorder.ui.navigation.ScreensRoutes
import com.example.foodorder.ui.theme.Yellow500
import com.example.foodorder.ui.viewmodels.UserViewModel
import kotlinx.coroutines.launch

@Composable
fun RegistrationScreen(navController: NavHostController, userViewModel: UserViewModel) {
    Log.d("Navigation", "Navigating to RegistrationScreen")
    Registration(navController = navController, userViewModel = userViewModel)
}

@Composable
fun Registration(navController: NavHostController, userViewModel: UserViewModel) {

    val scope = rememberCoroutineScope()

    var userName by remember {
        mutableStateOf("")
    }
    var userEmail by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

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
                onUserNameChange = { userName = it },
                onUserEmailChange = { userEmail = it },
                onPasswordChange = { password = it }
            )

            RegFooter(
                onRegClick = {
                    scope.launch {
                        val newUser = User(name = userName, email = userEmail, password = password)
                        userViewModel.registerUser(newUser)
                        navController.navigate(ScreensRoutes.Home.route)
                    }
                },
            )
        }
    }
}

@Composable
fun RegHeader() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = stringResource(R.string.hi),
            fontSize = 36.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Text(
            text = stringResource(R.string.register_to_continue),
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun RegField(
    userName: String,
    userEmail: String,
    password: String,
    onUserNameChange: (String) -> Unit,
    onUserEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
) {
    Column {

        DemoField(
            value = userName,
            label = "UserName",
            placeholder = "Enter your name",
            onValueChange = onUserNameChange,
            leadingIcon = {
                Icon(Icons.Default.AccountBox, contentDescription = "name")
            }
        )
        Spacer(modifier = Modifier.height(2.dp))
        DemoField(
            value = userEmail,
            label = "userEmail",
            placeholder = "Enter your email address",
            onValueChange = onUserEmailChange,
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
            leadingIcon = {
                Icon(Icons.Default.Lock, contentDescription = "pass")
            }
        )
    }
}

@Composable
fun RegFooter(
    onRegClick: () -> Unit,
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Button(
            onClick = onRegClick, modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Yellow500,
                contentColor = Color.Red
            )
        ) {
            Text(text = stringResource(R.string.register))
        }
    }
}

@Composable
fun DemoField(
    value: String,
    label: String,
    placeholder: String,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        placeholder = {
            Text(
                text = placeholder
            )
        },
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon
    )
}

