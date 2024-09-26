package com.example.shoppinglistcompose.data.repository

import com.example.shoppinglistcompose.data.MainListItem
import com.example.shoppinglistcompose.data.room.MainListDao
import kotlinx.coroutines.flow.Flow

class MainListRepositoryImpl(
    private val dao: MainListDao
) : MainListRepository {
    override suspend fun insertItem(item: MainListItem) {
        dao.insertItem(item)
    }

    override suspend fun deleteItem(item: MainListItem) {
        dao.deleteItem(item)
    }

    override fun getAllItems(): Flow<List<MainListItem>> {
        return dao.getAllItems()
    }
}