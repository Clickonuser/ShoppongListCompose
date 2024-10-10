package com.example.shoppinglistcompose.dialog

sealed class DialogEvent {
    data class OnTextChange(val text: String) : DialogEvent()
    data object OnConfirm : DialogEvent()
    data object OnDismiss : DialogEvent()
}