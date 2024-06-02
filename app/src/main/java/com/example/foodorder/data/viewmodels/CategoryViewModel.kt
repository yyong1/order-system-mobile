package com.example.foodorder.data.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodorder.data.models.Category
import com.example.foodorder.data.repository.CategoryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CategoryViewModel(private val categoryRepository: CategoryRepository) : ViewModel() {

    private val _allCategories = MutableStateFlow<List<Category>>(emptyList())
    val allCategories: StateFlow<List<Category>> = _allCategories.asStateFlow()

    private val _selectedCategory = MutableStateFlow<Category?>(null)
    val selectedCategory: StateFlow<Category?> = _selectedCategory.asStateFlow()

    init {
        fetchAllCategories()
    }

    private fun fetchAllCategories() {
        viewModelScope.launch {
            val categories = categoryRepository.getAllCategories()
            _allCategories.value = categories
        }
    }

    fun saveCategory(category: Category) {
        viewModelScope.launch {
            categoryRepository.saveCategory(category)
            fetchAllCategories()
        }
    }

    fun selectCategory(category: Category) {
        _selectedCategory.value = category
    }
}
