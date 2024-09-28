package com.example.shoppinglistcompose.main_screen

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.shoppinglistcompose.ui.theme.MyPink

@Composable
fun NavBar() {

    val listNavBarItems = listOf(
        NavBarItem.ListItem,
        NavBarItem.NoteItem,
        NavBarItem.AboutItem,
        NavBarItem.SettingsItem
    )

    NavigationBar {
        listNavBarItems.forEach { navItem ->
            NavigationBarItem(
                selected = false,
                onClick = { },
                icon = {
                    Icon(
                        painter = painterResource(id = navItem.imageId),
                        contentDescription = "icon"
                    )
                },
                label = {
                    Text(text = navItem.label)
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MyPink,
                    unselectedIconColor = Color.Gray,
                    selectedTextColor = MyPink,
                    unselectedTextColor = Color.Gray,
                ),
                alwaysShowLabel = false
            )
        }
    }
}