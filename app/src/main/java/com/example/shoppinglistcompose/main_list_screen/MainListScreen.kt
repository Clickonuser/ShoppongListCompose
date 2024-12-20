package com.example.shoppinglistcompose.main_list_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.shoppinglistcompose.dialog.MainDialog

@Composable
fun MainListScreen(
    viewModel: MainListViewModel = hiltViewModel()
) {
    val items = viewModel.list.collectAsState(initial = emptyList())

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentPadding = PaddingValues(bottom = 100.dp)
    ) {
        items(items.value) {
            UiMainListItem(it) { event ->
                viewModel.onEvent(event)
            }
        }
    }
    MainDialog(viewModel)
}