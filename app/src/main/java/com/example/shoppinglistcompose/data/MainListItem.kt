package com.example.shoppinglistcompose.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "main_table")
data class MainListItem(
    @PrimaryKey
    val id: Int? = null,
    val name: String,
    val time: String,
    val allItemCount: Int,
    val selectedItemCount: Int,
)
