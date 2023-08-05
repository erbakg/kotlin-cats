package com.example.ktorclient.data.remote.api.catImages

import com.example.ktorclient.data.remote.api.dto.CatImageResponse
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logging

interface CatImagesApiService {
    suspend fun getCatImages(): List<CatImageResponse>

    companion object {
        fun create(): CatImagesApiService {
            return CatImagesImpl(
                client = HttpClient(Android){
                    install(Logging){
                        level = LogLevel.ALL
                    }
                    install(JsonFeature){
                        serializer = KotlinxSerializer()
                    }
                }
            )
        }
    }
}