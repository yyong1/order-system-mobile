package com.example.foodorder.ui.screens.orders

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.foodorder.data.viewmodels.OrderViewModel
import kotlinx.coroutines.launch
import java.util.*

@Composable
fun OrderHistoryScreen(orderViewModel: OrderViewModel) {
    val orders by orderViewModel.orders.collectAsState(initial = emptyList())
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        orderViewModel.fetchAllOrders()
        Log.d("OrderHistoryScreen", "Fetching all orders")
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        FilterOptions { startDate, endDate ->
            Log.d("OrderHistoryScreen", "Filter selected: startDate=$startDate, endDate=$endDate")
            coroutineScope.launch {
                orderViewModel.fetchOrders(userId = 1, startDate, endDate)
            }
        }

        FavoriteRestaurant("Favorite Restaurant")

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(orders) { order ->
                OrderItem(order)
            }
        }
    }
}

@Composable
fun FilterOptions(onFilterSelected: (Date, Date) -> Unit) {
    var selectedFilter by remember { mutableStateOf("This Week") }

    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        listOf("This Week", "This Month", "All Time").forEach { filter ->
            Button(onClick = {
                selectedFilter = filter
                val (startDate, endDate) = when (filter) {
                    "This Week" -> getStartAndEndOfWeek()
                    "This Month" -> getStartAndEndOfMonth()
                    else -> getStartAndEndOfAllTime()
                }
                Log.d("FilterOptions", "Button clicked: filter=$filter, startDate=$startDate, endDate=$endDate")
                onFilterSelected(startDate, endDate)
            }) {
                Text(text = filter)
            }
        }
    }
}

@Composable
fun FavoriteRestaurant(restaurantName: String) {
    Text(text = "Favorite Restaurant: $restaurantName", style = MaterialTheme.typography.h6)
}

fun getStartAndEndOfWeek(): Pair<Date, Date> {
    val calendar = Calendar.getInstance()
    calendar.set(Calendar.DAY_OF_WEEK, calendar.firstDayOfWeek)
    val startDate = calendar.time
    calendar.add(Calendar.DAY_OF_WEEK, 6)
    val endDate = calendar.time
    return Pair(startDate, endDate)
}

fun getStartAndEndOfMonth(): Pair<Date, Date> {
    val calendar = Calendar.getInstance()
    calendar.set(Calendar.DAY_OF_MONTH, 1)
    val startDate = calendar.time
    calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH))
    val endDate = calendar.time
    return Pair(startDate, endDate)
}

fun getStartAndEndOfAllTime(): Pair<Date, Date> {
    val startDate = Date(0)
    val endDate = Date()
    return Pair(startDate, endDate)
}
