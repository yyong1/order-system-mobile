package com.example.foodorder.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.foodorder.data.database.UserRepository
import com.example.foodorder.data.models.User

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {

    suspend fun registerUser(user: User) {
        userRepository.registerUser(user)
    }

    suspend fun getUserByEmail(email: String): User? {
        return userRepository.getUserByEmail(email)
    }

    suspend fun checkUser(email: String, password: String): Boolean {
        val user = userRepository.getUserByEmail(email)
        if (user?.email == email && user?.password == password) true
        return false
    }
}
