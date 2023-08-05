package com.example.ktorclient.data.remote.api.dto

import kotlinx.serialization.Serializable

@Serializable
data class ImageDataResponse(
    val id: String,
    val url: String,
    val width: Int,
    val height: Int,
    val mime_type: String,
    val breeds: List<Breed>,
    val breed_ids: String
)
