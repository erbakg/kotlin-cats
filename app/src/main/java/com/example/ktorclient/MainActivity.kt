package com.example.ktorclient

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ktorclient.data.BottomNavItem
import com.example.ktorclient.data.remote.api.catImages.CatImagesApiService
import com.example.ktorclient.data.remote.api.imageData.ImageDataApiService
import com.example.ktorclient.ui.navigation.BottomNavigationBar
import com.example.ktorclient.ui.screens.BreedsScreen
import com.example.ktorclient.ui.screens.HomeScreen
import com.example.ktorclient.ui.theme.KtorClientTheme

val bottomItems = listOf<BottomNavItem>(
    BottomNavItem("Cats", "cats", Icons.Default.Favorite),
    BottomNavItem("Breeds", "breeds", Icons.Default.List)
)

class MainActivity : ComponentActivity() {
    private val catImagesService = CatImagesApiService.create()
    private  val imageDataService = ImageDataApiService.create()
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
                            navController = navController,
                            service = catImagesService,
                            imageService = imageDataService
                        )
                    }

                }
            }
        }
    }
}

@Composable
fun Navigation(modifier: Modifier, navController: NavHostController, service: CatImagesApiService, imageService: ImageDataApiService) {
    NavHost(navController = navController, startDestination = bottomItems[0].route) {
        composable(bottomItems[0].route) {
            HomeScreen(service, imageService)
        }
        composable(bottomItems[1].route) {
            BreedsScreen()
        }
    }

}
