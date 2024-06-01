package com.example.foodorder.data.viewmodels

import androidx.lifecycle.ViewModel
import com.example.foodorder.data.repository.UserRepository
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
        return (user?.email == email && user?.password == password)
    }

    suspend fun updateUser(userId: Int, name: String, email: String, favoriteRestaurant: String) {
        userRepository.updateUser(userId, name, email, favoriteRestaurant)
    }

    suspend fun getUserById(userId: Int): User? {
        return userRepository.getUserById(userId)
    }
}
