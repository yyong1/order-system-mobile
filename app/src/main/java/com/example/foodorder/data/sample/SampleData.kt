package com.example.foodorder.data.sample

import com.example.foodorder.R
import com.example.foodorder.data.models.*
import java.util.Date

object SampleData {

    val categories = listOf(
        Category(categoryId = 1, name = "Beverages", iconResId = R.drawable.primavera_pizza),
        Category(categoryId = 2, name = "Fast Food", iconResId = R.drawable.salad_pesto_pizza),
        Category(categoryId = 3, name = "Desserts", iconResId = R.drawable.pizza)
    )

    val restaurants = listOf(
        Restaurant(id = 1, name = "Sarajevo Grill", locationLatitude = 43.8563, locationLongitude = 18.4131, isPopular = true),
        Restaurant(id = 2, name = "Bosnian Bites", locationLatitude = 43.8600, locationLongitude = 18.4100, isPopular = false)
    )

    val menus = listOf(
        Menu(menuId = 1, restaurantId = 1, title = "Cevapi", description = "Grilled minced meat", price = 5.0, rate = 4.5, calories = 300.0, scheduleTime = 15.0, categoryId = 2, ingredients = listOf(), isPopular = true),
        Menu(menuId = 2, restaurantId = 1, title = "Pljeskavica", description = "Grilled meat patty", price = 6.0, rate = 4.7, calories = 350.0, scheduleTime = 20.0, categoryId = 2, ingredients = listOf(), isPopular = false),
        Menu(menuId = 3, restaurantId = 2, title = "Burek", description = "Pastry filled with meat", price = 4.0, rate = 4.3, calories = 250.0, scheduleTime = 10.0, categoryId = 2, ingredients = listOf(), isPopular = true)
    )

    val users = listOf(
        User(id = 1, name = "John Doe", email = "john.doe@example.com", password = "password123"),
        User(id = 2, name = "Jane Smith", email = "jane.smith@example.com", password = "password123")
    )

    val orders = listOf(
        Order(orderId = 1, userId = 1, restaurantId = 1, orderDate = Date().toString(), totalPrice = 11.0),
        Order(orderId = 2, userId = 2, restaurantId = 2, orderDate = Date().toString(), totalPrice = 4.0)
    )

    val orderMenus = listOf(
        OrderMenu(orderId = 1, menuId = 1, quantity = 2),
        OrderMenu(orderId = 1, menuId = 2, quantity = 1),
        OrderMenu(orderId = 2, menuId = 3, quantity = 1)
    )
}
