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
import androidx.navigation.compose.rememberNavController
import com.example.shoppinglistcompose.ui.theme.MyPink

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavBar()

        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
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

    }
}