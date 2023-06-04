package com.example.foodorder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.example.foodorder.data.database.AppDatabase
import com.example.foodorder.data.database.UserRepository
import com.example.foodorder.ui.navigation.Navigation
import com.example.foodorder.ui.theme.FoodOrderTheme
import com.example.foodorder.ui.viewmodels.UserViewModel
import com.example.foodorder.ui.viewmodels.UserViewModelFactory


class MainActivity : ComponentActivity() {
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val userDao = AppDatabase.getInstance(this).userDao()
        val userRepository = UserRepository(userDao)
        val userViewModelFactory = UserViewModelFactory(userRepository)
        userViewModel = ViewModelProvider(this, userViewModelFactory)[UserViewModel::class.java]


        setContent {
            FoodOrderTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize()) {
                    val navController = rememberNavController()
                    Navigation(navController = navController, userViewModel = userViewModel)
                }
            }
        }
    }
}