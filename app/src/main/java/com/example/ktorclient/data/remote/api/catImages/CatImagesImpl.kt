package com.example.ktorclient.data.remote.api.catImages

import com.example.ktorclient.data.remote.api.HttpRoutes
import com.example.ktorclient.data.remote.api.dto.CatImageResponse
import io.ktor.client.HttpClient
import io.ktor.client.features.ClientRequestException
import io.ktor.client.features.RedirectResponseException
import io.ktor.client.features.ServerResponseException
import io.ktor.client.request.get
import io.ktor.client.request.url

class CatImagesImpl(
    private val client: HttpClient
) : CatImagesApiService {
    override suspend fun getCatImages(): List<CatImageResponse> {
        return try {
            client.get {
                url(HttpRoutes.IMAGES)
            }
        } catch (e: RedirectResponseException) {
            //3XX - responses
            println("Error ${e.response.status.description}")
            emptyList()
        } catch (e: ClientRequestException) {
            //4XX - responses
            println("Error ${e.response.status.description}")
            emptyList()
        } catch (e: ServerResponseException) {
            //5XX - responses
            println("Error ${e.response.status.description}")
            emptyList()
        } catch (e: Exception) {
            //5XX - responses
            println("Error ${e.message}")
            emptyList()
        }
    }
}