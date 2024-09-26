package com.example.shoppinglistcompose.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.shoppinglistcompose.data.MainListItem
import kotlinx.coroutines.flow.Flow

@Dao
interface MainListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: MainListItem)
    @Delete
    suspend fun deleteItem(item: MainListItem)
    @Query("SELECT * FROM main_table")
    fun getAllItems(): Flow<List<MainListItem>>
}