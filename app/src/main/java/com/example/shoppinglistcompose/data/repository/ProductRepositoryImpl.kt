package com.example.shoppinglistcompose.data.repository

import com.example.shoppinglistcompose.data.MainListItem
import com.example.shoppinglistcompose.data.ProductItem
import com.example.shoppinglistcompose.data.room.ProductDao
import kotlinx.coroutines.flow.Flow

class ProductRepositoryImpl(
    private val dao: ProductDao
) : ProductRepository {
    override suspend fun insertItem(item: ProductItem) {
        dao.insertItem(item)
    }

    override suspend fun deleteItem(item: ProductItem) {
        dao.deleteItem(item)
    }

    override fun getAllItemsById(mainListId: Int): Flow<List<ProductItem>> {
        return dao.getAllItemsById(mainListId)
    }

    override suspend fun getMainListItemById(id: Int): MainListItem {
        return dao.getMainListItemById(id)
    }

    override suspend fun updateMainListItem(item: MainListItem) {
        dao.updateMainListItem(item)
    }
}