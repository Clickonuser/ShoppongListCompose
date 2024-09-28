package com.example.shoppinglistcompose.main_screen

import com.example.shoppinglistcompose.R
import com.example.shoppinglistcompose.utils.Routes

sealed class NavBarItem(val label: String, val imageId: Int, val route: String) {
    data object ListItem: NavBarItem("List", R.drawable.main_list_icon, Routes.MAIN_LIST_SCREEN)
    data object NoteItem: NavBarItem("Note", R.drawable.note_icon, Routes.NOTE_SCREEN)
    data object AboutItem: NavBarItem("Info", R.drawable.info_icon, Routes.INFO_SCREEN)
    data object SettingsItem: NavBarItem("Settings", R.drawable.settings_icon, Routes.SETTINGS_SCREEN)
}