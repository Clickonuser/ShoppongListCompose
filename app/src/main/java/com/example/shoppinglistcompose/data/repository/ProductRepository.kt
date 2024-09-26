package com.example.shoppinglistcompose.data.repository

import com.example.shoppinglistcompose.data.MainListItem
import com.example.shoppinglistcompose.data.ProductItem
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    suspend fun insertItem(item: ProductItem)
    suspend fun deleteItem(item: ProductItem)
    fun getAllItemsById(mainListId: Int): Flow<List<ProductItem>>
    suspend fun getMainListItemById(id: Int): MainListItem
    suspend fun updateMainListItem(item: MainListItem)
}