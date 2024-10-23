package com.example.shoppinglistcompose.dialog

import androidx.compose.runtime.MutableState

interface DialogController {
    val dialogTitle: MutableState<String>
    val editableText: MutableState<String>
    val showDialog: MutableState<Boolean>
    val showEditableText: MutableState<Boolean>
    fun onDialogEvent(event: DialogEvent)
}