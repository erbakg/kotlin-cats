package com.example.ktorclient.data.remote.api.dto

import kotlinx.serialization.Serializable

@Serializable
data class CatImageResponse(
    val id: String,
    val url: String,
    val width: Int,
    val height: Int
)
