package com.example.shoppinglistcompose.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "add_table")
data class AddItem(
    @PrimaryKey
    val id: Int? = null,
    val name: String,
    val isChecked: Boolean,
    val shoppingListId: Int
)
