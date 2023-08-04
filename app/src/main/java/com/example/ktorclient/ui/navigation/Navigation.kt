package com.example.ktorclient.ui.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.ktorclient.bottomItems
import com.example.ktorclient.data.BottomNavItem
import com.example.ktorclient.ui.screens.BreedsScreen
import com.example.ktorclient.ui.screens.HomeScreen

@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    navController: NavHostController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {
    val backStateEntry = navController.currentBackStackEntryAsState()
    BottomAppBar(modifier = modifier, containerColor = Color.Cyan, tonalElevation = 5.dp) {
        items.forEach { it ->
            val selected = it.route == backStateEntry.value?.destination?.route
            NavigationBarItem(
                selected = selected,
                onClick = { onItemClick(it) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Magenta,
                    unselectedIconColor = Color.White
                ),
                icon = {
                    Column (horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = it.Icon,
                            contentDescription = it.name
                        )
                        if (selected) {
                            Text(
                                text = it.name,
                                textAlign = TextAlign.Center,
                                fontSize = 10.sp
                            )
                        }
                    }

                })
        }


    }
}