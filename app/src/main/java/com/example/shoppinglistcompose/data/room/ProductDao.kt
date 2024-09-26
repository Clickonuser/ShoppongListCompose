package com.example.shoppinglistcompose.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.shoppinglistcompose.data.ProductItem
import com.example.shoppinglistcompose.data.MainListItem
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: ProductItem)
    @Delete
    suspend fun deleteItem(item: ProductItem)
    @Query("SELECT * FROM product_table WHERE mainListId = :mainListId")
    fun getAllItemsById(mainListId: Int): Flow<List<ProductItem>>
    @Query("SELECT * FROM main_table WHERE id = :id")
    suspend fun getMainListItemById(id: Int): MainListItem
    @Update
    suspend fun updateMainListItem(item: MainListItem)
}