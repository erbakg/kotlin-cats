package com.example.ktorclient

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.ktorclient.data.BottomNavItem
import com.example.ktorclient.ui.navigation.BottomNavigationBar
import com.example.ktorclient.ui.screens.BreedsScreen
import com.example.ktorclient.ui.screens.HomeScreen
import com.example.ktorclient.ui.theme.KtorClientTheme

val bottomItems = listOf<BottomNavItem>(
    BottomNavItem("Cats", "cats", Icons.Default.Favorite),
    BottomNavItem("Breeds", "breeds", Icons.Default.List)
)

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KtorClientTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    Scaffold(bottomBar = {
                        BottomNavigationBar(
                            items = bottomItems,
                            navController = navController,
                            onItemClick = {
                                navController.navigate(it.route)
                            }
                        )
                    }
                    ) {
                        Navigation(
                            modifier = Modifier
                                .padding(it),
                            navController = navController
                        )
                    }

                }
            }
        }
    }
}

@Composable
fun Navigation(modifier: Modifier, navController: NavHostController) {
    NavHost(navController = navController, startDestination = bottomItems[0].route) {
        composable(bottomItems[0].route) {
            HomeScreen()
        }
        composable(bottomItems[1].route) {
            BreedsScreen()
        }
    }

}
