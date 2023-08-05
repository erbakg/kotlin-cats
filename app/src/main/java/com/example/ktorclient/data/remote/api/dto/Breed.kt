package com.example.ktorclient.data.remote.api.dto

import kotlinx.serialization.Serializable

@Serializable
data class Breed(
    val id: Int,
    val name: String,
)
