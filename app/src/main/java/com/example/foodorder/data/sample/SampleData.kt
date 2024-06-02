package com.example.foodorder.data.sample

import com.example.foodorder.R
import com.example.foodorder.data.models.Category
import com.example.foodorder.data.models.Menu
import com.example.foodorder.data.models.Order
import com.example.foodorder.data.models.OrderMenu
import com.example.foodorder.data.models.Restaurant
import com.example.foodorder.data.models.User
import java.util.Date

object SampleData {

    val categories = listOf(
        Category(categoryId = 1, name = "Beverages", iconResId = R.drawable.primavera_pizza),
        Category(categoryId = 2, name = "Fast Food", iconResId = R.drawable.salad_pesto_pizza),
        Category(categoryId = 3, name = "Desserts", iconResId = R.drawable.pizza)
    )

    val restaurants = listOf(
        Restaurant(
            id = 1,
            name = "Sarajevo Grill",
            locationLatitude = 43.855,
            locationLongitude = 18.415,
            isPopular = true
        ),
        Restaurant(
            id = 2,
            name = "Sarajevo Burek",
            locationLatitude = 43.854,
            locationLongitude = 18.415,
            isPopular = true
        ),
        Restaurant(
            id = 3,
            name = "Bosnian Bites",
            locationLatitude = 43.853,
            locationLongitude = 18.413,
            isPopular = false
        ),
        Restaurant(
            id = 4,
            name = "Sarajevo Kebab",
            locationLatitude = 43.856,
            locationLongitude = 18.414,
            isPopular = true
        ),
        Restaurant(
            id = 5,
            name = "Sarajevo Pizza",
            locationLatitude = 43.853,
            locationLongitude = 18.416,
            isPopular = false
        ),
        Restaurant(
            id = 6,
            name = "Sarajevo Sweets",
            locationLatitude = 43.856,
            locationLongitude = 18.417,
            isPopular = true
        ),
        Restaurant(
            id = 7,
            name = "Sarajevo Cafe",
            locationLatitude = 43.852,
            locationLongitude = 18.418,
            isPopular = false
        ),
        Restaurant(
            id = 8,
            name = "Sarajevo Bakery",
            locationLatitude = 43.851,
            locationLongitude = 18.414,
            isPopular = true
        ),
        Restaurant(
            id = 9,
            name = "Sarajevo Diner",
            locationLatitude = 43.855,
            locationLongitude = 18.416,
            isPopular = false
        ),
        Restaurant(
            id = 10,
            name = "Sarajevo Lounge",
            locationLatitude = 43.854,
            locationLongitude = 18.419,
            isPopular = true
        ),
        Restaurant(
            id = 11,
            name = "Sarajevo Deli",
            locationLatitude = 43.853,
            locationLongitude = 18.417,
            isPopular = false
        ),
        Restaurant(
            id = 12,
            name = "Sarajevo Noodles",
            locationLatitude = 43.852,
            locationLongitude = 18.415,
            isPopular = true
        )
    )

    val menus = listOf(
        // Restaurant 1
        Menu(
            menuId = 1,
            restaurantId = 1,
            resId = R.drawable.salad_pesto_pizza,
            title = "Cevapi-pizza",
            description = "Grilled minced meat and pizza",
            price = 5.0,
            rate = 4.5,
            calories = 300.0,
            scheduleTime = 15.0,
            categoryId = 2,
            ingredients = listOf(
                R.drawable.ing1,
                R.drawable.ing2,
                R.drawable.ing3,
                R.drawable.ing4,
                R.drawable.ing5,
            ),
            isPopular = true
        ),
        Menu(
            menuId = 13,
            restaurantId = 1,
            resId = R.drawable.salad_pesto_pizza,
            title = "Pesto Pizza",
            description = "Fresh pesto and mozzarella pizza",
            price = 7.0,
            rate = 4.8,
            calories = 280.0,
            scheduleTime = 12.0,
            categoryId = 2,
            ingredients = listOf(
                R.drawable.ing1,
                R.drawable.ing2,
                R.drawable.ing3,
                R.drawable.ing4,
                R.drawable.ing5,
            ),
            isPopular = true
        ),
        Menu(
            menuId = 14,
            restaurantId = 1,
            resId = R.drawable.primavera_pizza,
            title = "Margherita",
            description = "Classic margherita pizza",
            price = 6.0,
            rate = 4.6,
            calories = 260.0,
            scheduleTime = 10.0,
            categoryId = 2,
            ingredients = listOf(
                R.drawable.ing1,
                R.drawable.ing2,
                R.drawable.ing3,
                R.drawable.ing4,
                R.drawable.ing5,
            ),
            isPopular = true
        ),
        Menu(
            menuId = 15,
            restaurantId = 1,
            resId = R.drawable.primavera_pizza,
            title = "Pepperoni Pizza",
            description = "Pepperoni and cheese pizza",
            price = 8.0,
            rate = 4.7,
            calories = 320.0,
            scheduleTime = 14.0,
            categoryId = 2,
            ingredients = listOf(
                R.drawable.ing1,
                R.drawable.ing2,
                R.drawable.ing3,
                R.drawable.ing4,
                R.drawable.ing5,
            ),
            isPopular = true
        ),

        // Restaurant 2
        Menu(
            menuId = 2,
            restaurantId = 2,
            resId = R.drawable.primavera_pizza,
            title = "Pljeskavica-pizza",
            description = "Grilled meat patty and pizza",
            price = 6.0,
            rate = 4.7,
            calories = 350.0,
            scheduleTime = 20.0,
            categoryId = 2,
            ingredients = listOf(
                R.drawable.ing1,
                R.drawable.ing2,
                R.drawable.ing3,
                R.drawable.ing4,
                R.drawable.ing5,
            ),
            isPopular = false
        ),
        Menu(
            menuId = 16,
            restaurantId = 2,
            resId = R.drawable.primavera_pizza,
            title = "Four Seasons",
            description = "Four different toppings on one pizza",
            price = 9.0,
            rate = 4.9,
            calories = 400.0,
            scheduleTime = 18.0,
            categoryId = 2,
            ingredients = listOf(
                R.drawable.ing1,
                R.drawable.ing2,
                R.drawable.ing3,
                R.drawable.ing4,
                R.drawable.ing5,
            ),
            isPopular = true
        ),
        Menu(
            menuId = 17,
            restaurantId = 2,
            resId = R.drawable.primavera_pizza,
            title = "Hawaiian Pizza",
            description = "Ham and pineapple pizza",
            price = 7.5,
            rate = 4.4,
            calories = 310.0,
            scheduleTime = 15.0,
            categoryId = 2,
            ingredients = listOf(
                R.drawable.ing1,
                R.drawable.ing2,
                R.drawable.ing3,
                R.drawable.ing4,
                R.drawable.ing5,
            ),
            isPopular = true
        ),
        Menu(
            menuId = 18,
            restaurantId = 2,
            resId = R.drawable.primavera_pizza,
            title = "Vegetarian Pizza",
            description = "Pizza with assorted vegetables",
            price = 6.5,
            rate = 4.5,
            calories = 270.0,
            scheduleTime = 12.0,
            categoryId = 2,
            ingredients = listOf(
                R.drawable.ing1,
                R.drawable.ing2,
                R.drawable.ing3,
                R.drawable.ing4,
                R.drawable.ing5,
            ),
            isPopular = true
        ),

        // Restaurant 3
        Menu(
            menuId = 3,
            restaurantId = 3,
            resId = R.drawable.primavera_pizza,
            title = "Burek-pizza",
            description = "Pastry filled with meat and pizza",
            price = 4.0,
            rate = 4.3,
            calories = 250.0,
            scheduleTime = 10.0,
            categoryId = 2,
            ingredients = listOf(
                R.drawable.ing1,
                R.drawable.ing2,
                R.drawable.ing3,
                R.drawable.ing4,
                R.drawable.ing5,
            ),
            isPopular = true
        ),
        Menu(
            menuId = 19,
            restaurantId = 3,
            resId = R.drawable.primavera_pizza,
            title = "BBQ Chicken Pizza",
            description = "Chicken and BBQ sauce pizza",
            price = 8.0,
            rate = 4.6,
            calories = 340.0,
            scheduleTime = 16.0,
            categoryId = 2,
            ingredients = listOf(
                R.drawable.ing1,
                R.drawable.ing2,
                R.drawable.ing3,
                R.drawable.ing4,
                R.drawable.ing5,
            ),
            isPopular = true
        ),
        Menu(
            menuId = 20,
            restaurantId = 3,
            resId = R.drawable.primavera_pizza,
            title = "Buffalo Pizza",
            description = "Spicy buffalo chicken pizza",
            price = 7.5,
            rate = 4.7,
            calories = 330.0,
            scheduleTime = 14.0,
            categoryId = 2,
            ingredients = listOf(
                R.drawable.ing1,
                R.drawable.ing2,
                R.drawable.ing3,
                R.drawable.ing4,
                R.drawable.ing5,
            ),
            isPopular = true
        ),
        Menu(
            menuId = 21,
            restaurantId = 3,
            resId = R.drawable.primavera_pizza,
            title = "Mushroom Pizza",
            description = "Pizza with assorted mushrooms",
            price = 6.0,
            rate = 4.4,
            calories = 290.0,
            scheduleTime = 12.0,
            categoryId = 2,
            ingredients = listOf(
                R.drawable.ing1,
                R.drawable.ing2,
                R.drawable.ing3,
                R.drawable.ing4,
                R.drawable.ing5,
            ),
            isPopular = true
        ),

        // Restaurant 4
        Menu(
            menuId = 4,
            restaurantId = 4,
            resId = R.drawable.primavera_pizza,
            title = "Burek-pizza",
            description = "Pastry filled with meat and pizza",
            price = 4.0,
            rate = 4.3,
            calories = 250.0,
            scheduleTime = 10.0,
            categoryId = 2,
            ingredients = listOf(
                R.drawable.ing1,
                R.drawable.ing2,
                R.drawable.ing3,
                R.drawable.ing4,
                R.drawable.ing5,
            ),
            isPopular = true
        ),
        Menu(
            menuId = 22,
            restaurantId = 4,
            resId = R.drawable.primavera_pizza,
            title = "Mexican Pizza",
            description = "Spicy pizza with jalapeños",
            price = 7.0,
            rate = 4.5,
            calories = 300.0,
            scheduleTime = 14.0,
            categoryId = 2,
            ingredients = listOf(
                R.drawable.ing1,
                R.drawable.ing2,
                R.drawable.ing3,
                R.drawable.ing4,
                R.drawable.ing5,
            ),
            isPopular = true
        ),
        Menu(
            menuId = 23,
            restaurantId = 4,
            resId = R.drawable.primavera_pizza,
            title = "Supreme Pizza",
            description = "Loaded with toppings",
            price = 8.5,
            rate = 4.8,
            calories = 360.0,
            scheduleTime = 18.0,
            categoryId = 2,
            ingredients = listOf(
                R.drawable.ing1,
                R.drawable.ing2,
                R.drawable.ing3,
                R.drawable.ing4,
                R.drawable.ing5,
            ),
            isPopular = true
        ),
        Menu(
            menuId = 24,
            restaurantId = 4,
            resId = R.drawable.primavera_pizza,
            title = "Cheese Pizza",
            description = "Simple cheese pizza",
            price = 5.5,
            rate = 4.4,
            calories = 270.0,
            scheduleTime = 12.0,
            categoryId = 2,
            ingredients = listOf(
                R.drawable.ing1,
                R.drawable.ing2,
                R.drawable.ing3,
                R.drawable.ing4,
                R.drawable.ing5,
            ),
            isPopular = true
        ),

        // Restaurant 5
        Menu(
            menuId = 5,
            restaurantId = 5,
            resId = R.drawable.primavera_pizza,
            title = "Burek-pizza",
            description = "Pastry filled with meat and pizza",
            price = 4.0,
            rate = 4.3,
            calories = 250.0,
            scheduleTime = 10.0,
            categoryId = 2,
            ingredients = listOf(
                R.drawable.ing1,
                R.drawable.ing2,
                R.drawable.ing3,
                R.drawable.ing4,
                R.drawable.ing5,
            ),
            isPopular = true
        ),
        Menu(
            menuId = 25,
            restaurantId = 5,
            resId = R.drawable.primavera_pizza,
            title = "Meat Lovers Pizza",
            description = "Pizza with various meats",
            price = 9.0,
            rate = 4.7,
            calories = 380.0,
            scheduleTime = 18.0,
            categoryId = 2,
            ingredients = listOf(
                R.drawable.ing1,
                R.drawable.ing2,
                R.drawable.ing3,
                R.drawable.ing4,
                R.drawable.ing5,
            ),
            isPopular = true
        ),
        Menu(
            menuId = 26,
            restaurantId = 5,
            resId = R.drawable.primavera_pizza,
            title = "Seafood Pizza",
            description = "Pizza with assorted seafood",
            price = 10.0,
            rate = 4.6,
            calories = 350.0,
            scheduleTime = 20.0,
            categoryId = 2,
            ingredients = listOf(
                R.drawable.ing1,
                R.drawable.ing2,
                R.drawable.ing3,
                R.drawable.ing4,
                R.drawable.ing5,
            ),
            isPopular = true
        ),
        Menu(
            menuId = 27,
            restaurantId = 5,
            resId = R.drawable.primavera_pizza,
            title = "Garlic Chicken Pizza",
            description = "Garlic and chicken pizza",
            price = 8.5,
            rate = 4.5,
            calories = 330.0,
            scheduleTime = 15.0,
            categoryId = 2,
            ingredients = listOf(
                R.drawable.ing1,
                R.drawable.ing2,
                R.drawable.ing3,
                R.drawable.ing4,
                R.drawable.ing5,
            ),
            isPopular = true
        ),

        // Restaurant 6
        Menu(
            menuId = 6,
            restaurantId = 6,
            resId = R.drawable.primavera_pizza,
            title = "Burek-pizza",
            description = "Pastry filled with meat and pizza",
            price = 4.0,
            rate = 4.3,
            calories = 250.0,
            scheduleTime = 10.0,
            categoryId = 2,
            ingredients = listOf(
                R.drawable.ing1,
                R.drawable.ing2,
                R.drawable.ing3,
                R.drawable.ing4,
                R.drawable.ing5,
            ),
            isPopular = true
        ),
        Menu(
            menuId = 28,
            restaurantId = 6,
            resId = R.drawable.primavera_pizza,
            title = "BBQ Bacon Pizza",
            description = "Bacon and BBQ sauce pizza",
            price = 9.0,
            rate = 4.8,
            calories = 360.0,
            scheduleTime = 18.0,
            categoryId = 2,
            ingredients = listOf(
                R.drawable.ing1,
                R.drawable.ing2,
                R.drawable.ing3,
                R.drawable.ing4,
                R.drawable.ing5,
            ),
            isPopular = true
        ),
        Menu(
            menuId = 29,
            restaurantId = 6,
            resId = R.drawable.primavera_pizza,
            title = "Spinach Pizza",
            description = "Pizza with spinach and cheese",
            price = 7.0,
            rate = 4.5,
            calories = 290.0,
            scheduleTime = 14.0,
            categoryId = 2,
            ingredients = listOf(
                R.drawable.ing1,
                R.drawable.ing2,
                R.drawable.ing3,
                R.drawable.ing4,
                R.drawable.ing5,
            ),
            isPopular = true
        ),
        Menu(
            menuId = 30,
            restaurantId = 6,
            resId = R.drawable.primavera_pizza,
            title = "Artichoke Pizza",
            description = "Pizza with artichokes and cheese",
            price = 8.0,
            rate = 4.4,
            calories = 300.0,
            scheduleTime = 15.0,
            categoryId = 2,
            ingredients = listOf(
                R.drawable.ing1,
                R.drawable.ing2,
                R.drawable.ing3,
                R.drawable.ing4,
                R.drawable.ing5,
            ),
            isPopular = true
        ),

        // Restaurant 7
        Menu(
            menuId = 7,
            restaurantId = 7,
            resId = R.drawable.primavera_pizza,
            title = "Burek-pizza",
            description = "Pastry filled with meat and pizza",
            price = 4.0,
            rate = 4.3,
            calories = 250.0,
            scheduleTime = 10.0,
            categoryId = 2,
            ingredients = listOf(
                R.drawable.ing1,
                R.drawable.ing2,
                R.drawable.ing3,
                R.drawable.ing4,
                R.drawable.ing5,
            ),
            isPopular = true
        ),
        Menu(
            menuId = 31,
            restaurantId = 7,
            resId = R.drawable.primavera_pizza,
            title = "Greek Pizza",
            description = "Pizza with feta cheese and olives",
            price = 7.5,
            rate = 4.5,
            calories = 310.0,
            scheduleTime = 14.0,
            categoryId = 2,
            ingredients = listOf(
                R.drawable.ing1,
                R.drawable.ing2,
                R.drawable.ing3,
                R.drawable.ing4,
                R.drawable.ing5,
            ),
            isPopular = true
        ),
        Menu(
            menuId = 32,
            restaurantId = 7,
            resId = R.drawable.primavera_pizza,
            title = "Truffle Pizza",
            description = "Pizza with truffle oil and mushrooms",
            price = 12.0,
            rate = 4.9,
            calories = 380.0,
            scheduleTime = 20.0,
            categoryId = 2,
            ingredients = listOf(
                R.drawable.ing1,
                R.drawable.ing2,
                R.drawable.ing3,
                R.drawable.ing4,
                R.drawable.ing5,
            ),
            isPopular = true
        ),
        Menu(
            menuId = 33,
            restaurantId = 7,
            resId = R.drawable.primavera_pizza,
            title = "Caprese Pizza",
            description = "Pizza with fresh tomatoes and basil",
            price = 8.0,
            rate = 4.6,
            calories = 280.0,
            scheduleTime = 15.0,
            categoryId = 2,
            ingredients = listOf(
                R.drawable.ing1,
                R.drawable.ing2,
                R.drawable.ing3,
                R.drawable.ing4,
                R.drawable.ing5,
            ),
            isPopular = true
        ),

        // Restaurant 8
        Menu(
            menuId = 8,
            restaurantId = 8,
            resId = R.drawable.primavera_pizza,
            title = "Burek-pizza",
            description = "Pastry filled with meat and pizza",
            price = 4.0,
            rate = 4.3,
            calories = 250.0,
            scheduleTime = 10.0,
            categoryId = 2,
            ingredients = listOf(
                R.drawable.ing1,
                R.drawable.ing2,
                R.drawable.ing3,
                R.drawable.ing4,
                R.drawable.ing5,
            ),
            isPopular = true
        ),
        Menu(
            menuId = 34,
            restaurantId = 8,
            resId = R.drawable.primavera_pizza,
            title = "Cheddar Pizza",
            description = "Pizza with cheddar cheese",
            price = 7.0,
            rate = 4.5,
            calories = 290.0,
            scheduleTime = 12.0,
            categoryId = 2,
            ingredients = listOf(
                R.drawable.ing1,
                R.drawable.ing2,
                R.drawable.ing3,
                R.drawable.ing4,
                R.drawable.ing5,
            ),
            isPopular = true
        ),
        Menu(
            menuId = 35,
            restaurantId = 8,
            resId = R.drawable.primavera_pizza,
            title = "Pepperoni Pizza",
            description = "Pizza with pepperoni slices",
            price = 6.5,
            rate = 4.7,
            calories = 320.0,
            scheduleTime = 14.0,
            categoryId = 2,
            ingredients = listOf(
                R.drawable.ing1,
                R.drawable.ing2,
                R.drawable.ing3,
                R.drawable.ing4,
                R.drawable.ing5,
            ),
            isPopular = true
        ),
        Menu(
            menuId = 36,
            restaurantId = 8,
            resId = R.drawable.primavera_pizza,
            title = "Buffalo Chicken Pizza",
            description = "Pizza with buffalo chicken",
            price = 8.5,
            rate = 4.8,
            calories = 340.0,
            scheduleTime = 16.0,
            categoryId = 2,
            ingredients = listOf(
                R.drawable.ing1,
                R.drawable.ing2,
                R.drawable.ing3,
                R.drawable.ing4,
                R.drawable.ing5,
            ),
            isPopular = true
        ),

        // Restaurant 9
        Menu(
            menuId = 9,
            restaurantId = 9,
            resId = R.drawable.primavera_pizza,
            title = "Burek-pizza",
            description = "Pastry filled with meat and pizza",
            price = 4.0,
            rate = 4.3,
            calories = 250.0,
            scheduleTime = 10.0,
            categoryId = 2,
            ingredients = listOf(
                R.drawable.ing1,
                R.drawable.ing2,
                R.drawable.ing3,
                R.drawable.ing4,
                R.drawable.ing5,
            ),
            isPopular = true
        ),
        Menu(
            menuId = 37,
            restaurantId = 9,
            resId = R.drawable.primavera_pizza,
            title = "Four Cheese Pizza",
            description = "Pizza with four types of cheese",
            price = 7.0,
            rate = 4.6,
            calories = 300.0,
            scheduleTime = 14.0,
            categoryId = 2,
            ingredients = listOf(
                R.drawable.ing1,
                R.drawable.ing2,
                R.drawable.ing3,
                R.drawable.ing4,
                R.drawable.ing5,
            ),
            isPopular = true
        ),
        Menu(
            menuId = 38,
            restaurantId = 9,
            resId = R.drawable.primavera_pizza,
            title = "Sausage Pizza",
            description = "Pizza with sausage slices",
            price = 7.5,
            rate = 4.7,
            calories = 330.0,
            scheduleTime = 16.0,
            categoryId = 2,
            ingredients = listOf(
                R.drawable.ing1,
                R.drawable.ing2,
                R.drawable.ing3,
                R.drawable.ing4,
                R.drawable.ing5,
            ),
            isPopular = true
        ),
        Menu(
            menuId = 39,
            restaurantId = 9,
            resId = R.drawable.primavera_pizza,
            title = "Pineapple Pizza",
            description = "Pizza with pineapple chunks",
            price = 6.0,
            rate = 4.5,
            calories = 280.0,
            scheduleTime = 12.0,
            categoryId = 2,
            ingredients = listOf(
                R.drawable.ing1,
                R.drawable.ing2,
                R.drawable.ing3,
                R.drawable.ing4,
                R.drawable.ing5,
            ),
            isPopular = true
        ),

        // Restaurant 10
        Menu(
            menuId = 10,
            restaurantId = 10,
            resId = R.drawable.primavera_pizza,
            title = "Burek-pizza",
            description = "Pastry filled with meat and pizza",
            price = 4.0,
            rate = 4.3,
            calories = 250.0,
            scheduleTime = 10.0,
            categoryId = 2,
            ingredients = listOf(
                R.drawable.ing1,
                R.drawable.ing2,
                R.drawable.ing3,
                R.drawable.ing4,
                R.drawable.ing5,
            ),
            isPopular = true
        ),
        Menu(
            menuId = 40,
            restaurantId = 10,
            resId = R.drawable.primavera_pizza,
            title = "Veggie Delight Pizza",
            description = "Pizza with assorted vegetables",
            price = 7.0,
            rate = 4.6,
            calories = 280.0,
            scheduleTime = 14.0,
            categoryId = 2,
            ingredients = listOf(
                R.drawable.ing1,
                R.drawable.ing2,
                R.drawable.ing3,
                R.drawable.ing4,
                R.drawable.ing5,
            ),
            isPopular = true
        ),
        Menu(
            menuId = 41,
            restaurantId = 10,
            resId = R.drawable.primavera_pizza,
            title = "Margherita Pizza",
            description = "Classic margherita pizza",
            price = 6.5,
            rate = 4.7,
            calories = 290.0,
            scheduleTime = 12.0,
            categoryId = 2,
            ingredients = listOf(
                R.drawable.ing1,
                R.drawable.ing2,
                R.drawable.ing3,
                R.drawable.ing4,
                R.drawable.ing5,
            ),
            isPopular = true
        ),
        Menu(
            menuId = 42,
            restaurantId = 10,
            resId = R.drawable.primavera_pizza,
            title = "Mushroom Pizza",
            description = "Pizza with fresh mushrooms",
            price = 7.5,
            rate = 4.6,
            calories = 300.0,
            scheduleTime = 15.0,
            categoryId = 2,
            ingredients = listOf(
                R.drawable.ing1,
                R.drawable.ing2,
                R.drawable.ing3,
                R.drawable.ing4,
                R.drawable.ing5,
            ),
            isPopular = true
        )
    )

    val users = listOf(
        User(
            id = 1,
            name = "John Doe",
            email = "john.doe@example.com",
            password = "password123",
            favoriteRestaurant = "Sarajevo Grill"
        ),
        User(
            id = 2,
            name = "Jane Smith",
            email = "jane.smith@example.com",
            password = "password123",
            favoriteRestaurant = ""
        )
    )

    val orders = listOf(
        Order(
            orderId = 1,
            userId = 1,
            restaurantId = 1,
            orderDate = Date().toString(),
            totalPrice = 11.0
        ),
        Order(
            orderId = 2,
            userId = 2,
            restaurantId = 2,
            orderDate = Date().toString(),
            totalPrice = 4.0
        )
    )

    val orderMenus = listOf(
        OrderMenu(orderId = 1, menuId = 1, quantity = 2),
        OrderMenu(orderId = 1, menuId = 2, quantity = 1),
        OrderMenu(orderId = 2, menuId = 3, quantity = 1)
    )
}
