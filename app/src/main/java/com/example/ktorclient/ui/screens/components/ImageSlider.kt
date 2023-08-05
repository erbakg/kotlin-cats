package com.example.ktorclient.ui.screens.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import com.example.ktorclient.data.remote.api.catImages.CatImagesApiService
import com.example.ktorclient.data.remote.api.dto.CatImageResponse

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageSlider(service: CatImagesApiService) {
    val catsImage = produceState<List<CatImageResponse>>(
        initialValue = emptyList(), producer = {
            value = service.getCatImages()
        })
    val pagerState = rememberPagerState()

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        catsImage?.value?.let { imagesList ->
            HorizontalPager(
                pageCount = imagesList.size,
                state = pagerState,
                key = {imagesList[it].id}
            ) {
                AsyncImage(
                    model = imagesList[it].url,
                    contentDescription = imagesList[it].id,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxSize()
                )

            }
        }
    }
}