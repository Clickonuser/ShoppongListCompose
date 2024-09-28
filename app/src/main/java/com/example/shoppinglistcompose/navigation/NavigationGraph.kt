package com.example.shoppinglistcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.shoppinglistcompose.info_screen.InfoScreen
import com.example.shoppinglistcompose.main_list_screen.MainListScreen
import com.example.shoppinglistcompose.note_screen.NoteScreen
import com.example.shoppinglistcompose.settings_screen.SettingsScreen
import com.example.shoppinglistcompose.utils.Routes

@Composable
fun NavigationGraph(navHostController: NavHostController) {

    NavHost(navController = navHostController, startDestination = Routes.MAIN_LIST_SCREEN) {
        composable(Routes.MAIN_LIST_SCREEN) {
            MainListScreen()
        }
        composable(Routes.NOTE_SCREEN) {
            NoteScreen()
        }
        composable(Routes.INFO_SCREEN) {
            InfoScreen()
        }
        composable(Routes.SETTINGS_SCREEN) {
            SettingsScreen()
        }
    }
}