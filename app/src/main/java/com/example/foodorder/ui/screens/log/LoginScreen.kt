package com.example.foodorder.ui.screens.log

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodorder.R
import com.example.foodorder.ui.theme.Yellow500

@Composable
fun LoginScreen() {
    Login()
}

@Composable
fun Login() {
    var username by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
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
            LoginHeader()
            LoginField(
                username,
                password,
                onUsernameChange = { username = it },
                onPasswordChange = { password = it },
                onForgotPasswordClick = {
                    // nav
                }
            )
            LoginFooter(
                onSignInClick = {
                    // navigation
                },
                onSignUpClick = {
                    // navigation
                }
            )
        }
    }
}

@Composable
fun LoginHeader() {
    Column(horizontalAlignment = Alignment.CenterHorizontally){
        Text(
            text = stringResource(R.string.welcome),
            fontSize = 36.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Text(
            text = stringResource(R.string.sigh_in_to_continue),
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun LoginField(
    username: String,
    password: String,
    onUsernameChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onForgotPasswordClick: () -> Unit
) {
    Column{
        DemoField(
            value = username,
            label = "Username",
            placeholder = "Enter your email address",
            onValueChange = onUsernameChange,
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
        TextButton(onClick = onForgotPasswordClick, modifier = Modifier.align(Alignment.End)) {
            Text(text = "Forgot password")
        }
    }
}

@Composable
fun LoginFooter(
    onSignInClick: () -> Unit,
    onSignUpClick: () -> Unit,
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally){
        Button(onClick = onSignInClick, modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Yellow500,
                contentColor = Color.Red)
            ) {
            Text(text = stringResource(R.string.sign_in))
        }
        TextButton(onClick = onSignUpClick) {
            Text(text = stringResource(R.string.don_t_have_an_account_click_here))
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginPreview() {
    LoginScreen()
}