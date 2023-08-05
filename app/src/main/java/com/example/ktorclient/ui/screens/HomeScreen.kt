package com.example.ktorclient.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.ktorclient.data.remote.api.catImages.CatImagesApiService
import com.example.ktorclient.data.remote.api.dto.CatImageResponse
import com.example.ktorclient.data.remote.api.imageData.ImageDataApiService
import com.example.ktorclient.ui.screens.components.ImageSlider
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(service: CatImagesApiService, imageService: ImageDataApiService) {

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center,

    ) {
        ImageSlider(service = service)
    }
}
