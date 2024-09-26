package com.example.shoppinglistcompose.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_table")
data class ProductItem(
    @PrimaryKey
    val id: Int? = null,
    val name: String,
    val isChecked: Boolean,
    val mainListId: Int
)
