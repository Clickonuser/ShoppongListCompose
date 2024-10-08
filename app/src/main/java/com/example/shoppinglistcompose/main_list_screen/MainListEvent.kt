package com.example.shoppinglistcompose.main_list_screen

import com.example.shoppinglistcompose.data.MainListItem

sealed class MainListEvent {
    data class OnShowDeleteDialog(val item: MainListItem) : MainListEvent()
    data class OnShowEditDialog(val item: MainListItem) : MainListEvent()
    data class OnItemClick(val item: MainListItem) : MainListEvent()
    data object OnItemAdd : MainListEvent()
}