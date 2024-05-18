package com.example.foodorder.ui.screens.map

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.foodorder.R
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState

data class Restaurant(
    val name: String,
    val location: LatLng,
    val description: String
)

val restaurantList = listOf(
    Restaurant("Restaurant 1", LatLng(43.855, 18.415), "TEST1"),
    Restaurant("Restaurant 2", LatLng(43.854, 18.414), "TEST2"),
    Restaurant("Restaurant 3", LatLng(43.853, 18.413), "TEST3")
)

@Composable
fun MapScreen() {
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.Builder()
            .target(restaurantList.firstOrNull()?.location ?: LatLng(0.0, 0.0))
            .zoom(16f)
            .build()
    }
    val context = LocalContext.current
    GoogleMap(
        cameraPositionState = cameraPositionState,
    ) {
        restaurantList.forEach { restaurant ->
            Marker(
                position = restaurant.location,
                title = restaurant.name,
                snippet = "Marker for ${restaurant.name}",
                icon = BitmapDescriptorFactory.fromBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.resources, R.drawable.location), 150, 150, false)),
                onClick = {marker ->
                    val rest = restaurantList.filter { res -> res.name == marker.title }[0]
                    Log.d("Restraunt", rest.description)
                    true
                }
            )
        }
    }
}
