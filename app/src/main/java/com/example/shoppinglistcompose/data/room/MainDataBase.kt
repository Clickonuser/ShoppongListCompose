package com.example.shoppinglistcompose.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.shoppinglistcompose.data.ProductItem
import com.example.shoppinglistcompose.data.MainListItem
import com.example.shoppinglistcompose.data.NoteItem

@Database(
    entities = [MainListItem::class, ProductItem::class, NoteItem::class],
    version = 1)
abstract class MainDataBase : RoomDatabase() {
    abstract val mainListDao: MainListDao
    abstract val productDao: ProductDao
    abstract val noteDao: NoteDao
}