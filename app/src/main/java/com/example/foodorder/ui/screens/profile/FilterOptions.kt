package com.example.foodorder.ui.screens.profile

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import java.util.*

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
                onFilterSelected(startDate, endDate)
            }) {
                Text(text = filter)
            }
        }
    }
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
