package com.example.ktorclient.data.remote.api

object HttpRoutes {
    private const val BASE_URL = "https://api.thecatapi.com/v1"
    const val  IMAGES = "$BASE_URL/images/search?limit=10"
    const val  IMAGE_DATA = "$BASE_URL/images/"
}