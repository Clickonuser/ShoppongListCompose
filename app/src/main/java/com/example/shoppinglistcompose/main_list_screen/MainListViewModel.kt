package com.example.shoppinglistcompose.main_list_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoppinglistcompose.data.MainListItem
import com.example.shoppinglistcompose.data.repository.MainListRepository
import com.example.shoppinglistcompose.dialog.DialogEvent
import com.example.shoppinglistcompose.utils.DialogController
import com.example.shoppinglistcompose.utils.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainListViewModel @Inject constructor(
    private val repository: MainListRepository
) : ViewModel(), DialogController {

    private val list = repository.getAllItems()

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    private var listItem: MainListItem? = null

    override var dialogTitle = mutableStateOf("")
        private set
    override var editableText = mutableStateOf("")
        private set
    override var showDialog = mutableStateOf(false)
        private set
    override var showEditableText = mutableStateOf(false)
        private set

    fun onEvent(event: MainListEvent) {
        when (event) {
            is MainListEvent.OnShowDeleteDialog -> {
                listItem = event.item
                showDialog.value = true
                dialogTitle.value = "Delete this item?"
                showEditableText.value = false
            }
            is MainListEvent.OnShowEditDialog -> {
                listItem = event.item
                showDialog.value = true
                editableText.value = listItem?.name ?: ""
                dialogTitle.value = "List name:"
                showEditableText.value = true
            }
            is MainListEvent.OnItemClick -> {
                sendUiEvent(UiEvent.Navigate(event.route))
            }
            is MainListEvent.OnItemAdd -> {
                viewModelScope.launch {
                    repository.insertItem(
                        MainListItem(
                            id = listItem?.id,
                            name = editableText.value,
                            time = "",
                            allItemCount = listItem?.allItemCount ?: 0,
                            selectedItemCount = listItem?.selectedItemCount ?: 0
                        )
                    )
                }
            }
        }
    }
    fun onDialogEvent(event: DialogEvent) {
        when (event) {
            is DialogEvent.OnTextChange -> {
                editableText.value = event.text
            }
            is DialogEvent.OnConfirm -> {
                if (showEditableText.value) {
                    onEvent(MainListEvent.OnItemAdd)
                } else {
                    viewModelScope.launch {
                        listItem?.let {
                            repository.deleteItem(it)
                        }
                    }
                }
                showDialog.value = false
            }
            is DialogEvent.OnDismiss -> {
                showDialog.value = false
            }
        }
    }
    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}