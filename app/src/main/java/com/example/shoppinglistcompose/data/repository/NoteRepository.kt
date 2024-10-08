package com.example.shoppinglistcompose.data.repository

import com.example.shoppinglistcompose.data.NoteItem
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    suspend fun insertItem(item: NoteItem)
    suspend fun deleteItem(item: NoteItem)
    fun getAllItems(): Flow<List<NoteItem>>
    suspend fun getNoteItemById(id: Int): NoteItem
}