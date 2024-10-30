package com.example.shoppinglistcompose.main_screen

sealed class MainScreenEvent {
    data object OnShowEditDialog : MainScreenEvent()
    data object OnItemAdd : MainScreenEvent()
}