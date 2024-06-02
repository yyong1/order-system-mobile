package com.example.foodorder.data.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodorder.data.models.Menu
import com.example.foodorder.data.repository.MenuRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MenuViewModel(private val repository: MenuRepository) : ViewModel() {

    val allMenus: StateFlow<List<Menu>> = repository.getAllMenus()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun saveMenu(menu: Menu) = viewModelScope.launch {
        repository.saveMenu(menu)
    }
    fun getMenusByRestaurantId(restaurantId: Int): StateFlow<List<Menu>> {
        return repository.getMenusByRestaurantId(restaurantId)
            .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())
    }

//    fun getAllMenus() = viewModelScope.launch {
//        repository.getAllMenus()
//    }
}