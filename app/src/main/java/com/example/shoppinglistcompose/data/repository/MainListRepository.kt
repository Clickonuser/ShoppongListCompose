package com.example.shoppinglistcompose.data.repository

import com.example.shoppinglistcompose.data.MainListItem
import kotlinx.coroutines.flow.Flow

interface MainListRepository {
    suspend fun insertItem(item: MainListItem)
    suspend fun deleteItem(item: MainListItem)
    fun getAllItems(): Flow<List<MainListItem>>
}