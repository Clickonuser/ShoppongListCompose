package com.example.shoppinglistcompose.main_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoppinglistcompose.data.MainListItem
import com.example.shoppinglistcompose.data.repository.MainListRepository
import com.example.shoppinglistcompose.dialog.DialogController
import com.example.shoppinglistcompose.dialog.DialogEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val repository: MainListRepository
) : ViewModel(), DialogController {

    override var dialogTitle = mutableStateOf("List name:")
        private set
    override var editableText = mutableStateOf("")
        private set
    override var showDialog = mutableStateOf(false)
        private set
    override var showEditableText = mutableStateOf(true)
        private set

    override fun onDialogEvent(event: DialogEvent) {
        when (event) {
            is DialogEvent.OnTextChange -> {
                editableText.value = event.text
            }
            is DialogEvent.OnConfirm -> {
                onEvent(MainScreenEvent.OnItemAdd)
                showDialog.value = false
            }
            is DialogEvent.OnDismiss -> {
                showDialog.value = false
            }
        }
    }

    fun onEvent(event: MainScreenEvent) {
        when (event) {
            is MainScreenEvent.OnShowEditDialog -> {
                showDialog.value = true
            }
            is MainScreenEvent.OnItemAdd -> {
                if (editableText.value.isEmpty()) return
                viewModelScope.launch {
                    repository.insertItem(
                        MainListItem(
                            id = null,
                            name = editableText.value,
                            time = "",
                            allItemCount = 0,
                            selectedItemCount = 0
                        )
                    )
                }
            }
        }
    }
}