package com.example.foodorder.ui.screens.map

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.foodorder.R
import com.example.foodorder.data.models.Menu
import com.example.foodorder.data.viewmodels.MenuViewModel
import com.example.foodorder.data.viewmodels.RestaurantViewModel
import com.example.foodorder.ui.navigation.ScreensRoutes
import com.example.foodorder.ui.screens.homepage.popular.PopularList
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch

data class RestaurantData(
    val id: Int,
    val name: String,
    val location: LatLng,
    val description: String
)


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MapScreen(
    navController: NavHostController,
    restaurantViewModel: RestaurantViewModel,
    menuViewModel: MenuViewModel
) {

    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current

    var restaurants by remember { mutableStateOf<List<RestaurantData>>(emptyList()) }
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.Builder()
            .target(restaurants.firstOrNull()?.location ?: LatLng(0.0, 0.0))
            .zoom(16f)
            .build()
    }

    val bottomSheetState =
        rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    var selectedRestaurant by remember { mutableStateOf<RestaurantData?>(null) }

    LaunchedEffect(Unit) {
        restaurantViewModel.fetchAllRestaurants()
        val fetchedRestaurants = restaurantViewModel.allRestaurants.first()
        Log.d("Res", "$fetchedRestaurants")
        restaurants = fetchedRestaurants.map { restaurant ->
            RestaurantData(
                restaurant.id,
                restaurant.name,
                LatLng(restaurant.locationLatitude, restaurant.locationLongitude),
                restaurant.name
            )
        }
        cameraPositionState.position = CameraPosition.Builder()
            .target(restaurants.firstOrNull()?.location ?: LatLng(0.0, 0.0))
            .zoom(16f)
            .build()
    }

    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetContent = {
            selectedRestaurant?.let { restaurant ->
                RestaurantInfoSheet(restaurant, menuViewModel, navController)
            }
        }
    ) {
        GoogleMap(
            cameraPositionState = cameraPositionState,
        ) {
            restaurants.forEach { restaurant ->
                Marker(
                    position = restaurant.location,
                    title = restaurant.name,
                    snippet = "Marker for ${restaurant.name}",
                    icon = BitmapDescriptorFactory.fromBitmap(
                        Bitmap.createScaledBitmap(
                            BitmapFactory.decodeResource(
                                context.resources,
                                R.drawable.location
                            ), 150, 150, false
                        )
                    ),
                    onClick = { marker ->
                        selectedRestaurant = restaurants.firstOrNull { it.name == marker.title }
                        if (selectedRestaurant != null) {
                            coroutineScope.launch {
                                bottomSheetState.show()
                            }
                        }
                        true
                    }
                )
            }
        }

        FloatingActionButton(
            onClick = { navController.navigate(ScreensRoutes.Home.route) },
            modifier = Modifier.padding(10.dp),
            backgroundColor = Color.Yellow
        ) {
            Icon(Icons.Filled.ArrowBack, contentDescription = "Back Button")
        }
    }
}

@Composable
fun RestaurantInfoSheet(restaurant: RestaurantData, menuViewModel: MenuViewModel, navController: NavHostController) {
    var menu by remember { mutableStateOf<List<Menu>>(emptyList()) }

    LaunchedEffect(restaurant) {
       // Fetch menu for the current restaurant
       val menuForRestaurant = menuViewModel.getMenusByRestaurantId(restaurant.id).firstOrNull()
        if (menuForRestaurant != null) {
            menu = menuForRestaurant
        }
   }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = restaurant.name, style = MaterialTheme.typography.h6)
        Text(text = restaurant.description, style = MaterialTheme.typography.body1)
        PopularList(popularList = menu, navController, onPopularDataClick = {})
    }
}
