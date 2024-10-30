package com.example.shoppinglistcompose.main_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.shoppinglistcompose.dialog.MainDialog
import com.example.shoppinglistcompose.main_list_screen.MainListViewModel
import com.example.shoppinglistcompose.navigation.NavigationGraph
import com.example.shoppinglistcompose.ui.theme.MyPink

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(
    viewModel: MainScreenViewModel = hiltViewModel()
) {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavBar(navController)

        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    viewModel.onEvent(MainScreenEvent.OnShowEditDialog)
                },
                shape = CircleShape,
                containerColor = MyPink,
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "add icon",
                    tint = Color.White
                )
            }
        },
        floatingActionButtonPosition = FabPosition.End,
    ) {
        NavigationGraph(navController)
        MainDialog(dialogController = viewModel)
    }
}