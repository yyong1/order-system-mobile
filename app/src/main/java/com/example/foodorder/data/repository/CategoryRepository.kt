package com.example.foodorder.data.repository

import com.example.foodorder.data.dao.CategoryDao
import com.example.foodorder.data.models.Category

class CategoryRepository(private val categoryDao: CategoryDao) {
    suspend fun saveCategory(category: Category) = categoryDao.insert(category)
    suspend fun getAllCategories(): List<Category> = categoryDao.getAllCategories()
}
