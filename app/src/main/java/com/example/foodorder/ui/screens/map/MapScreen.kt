package com.example.foodorder.ui.screens.map

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.foodorder.ui.theme.FoodOrderTheme
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MapScreen() {
    val sarajevo = LatLng(43.8563, 18.4131)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.Builder()
            .target(sarajevo)
            .zoom(10f)
            .build()
    }
    GoogleMap(cameraPositionState = cameraPositionState) {
        Marker(position = sarajevo, title = "Sarajevo", snippet = "Marker in Sarajevo")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FoodOrderTheme {
        MapScreen()
    }
}
