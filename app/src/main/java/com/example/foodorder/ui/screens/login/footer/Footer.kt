package com.example.foodorder.ui.screens.login.footer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.foodorder.R
import com.example.foodorder.ui.theme.Yellow500

@Composable
fun LoginFooter(
    onSignInClick: () -> Unit,
    onSignUpClick: () -> Unit,
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Button(
            onClick = onSignInClick,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Yellow500,
                contentColor = Color.Red
            )
        ) {
            Text(text = stringResource(R.string.sign_in))
        }
        TextButton(onClick = onSignUpClick) {
            Text(text = stringResource(R.string.don_t_have_an_account_click_here))
        }
    }
}
