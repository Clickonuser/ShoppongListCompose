package com.example.shoppinglistcompose.main_list_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoppinglistcompose.data.MainListItem
import com.example.shoppinglistcompose.data.repository.MainListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainListViewModel @Inject constructor(
    private val repository: MainListRepository
) : ViewModel() {

    private var listItem: MainListItem? = null

    fun onEvent(event: MainListEvent) {
        when (event) {
            is MainListEvent.OnShowDeleteDialog -> {

            }
            is MainListEvent.OnShowEditDialog -> {
                listItem = event.item
            }
            is MainListEvent.OnItemClick -> {

            }
            is MainListEvent.OnItemAdd -> {
                viewModelScope.launch {
                    repository.insertItem(
                        MainListItem(
                            id = listItem?.id,
                            name = "",
                            time = "",
                            allItemCount = listItem?.allItemCount ?: 0,
                            selectedItemCount = listItem?.selectedItemCount ?: 0
                        )
                    )
                }
            }

        }
    }
}