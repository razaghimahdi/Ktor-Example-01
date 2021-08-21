package com.example.ktor_example_01.networking

import com.example.ktor_example_01.networking.dto.GenericUserDTO
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import io.ktor.util.*


@KtorExperimentalAPI
object NetworkApi {


    /**
     * Constructs an asynchronous HttpClient using the specified engineFactory
     * and an optional block for configuring this client.
     */

    private val client = HttpClient(Android) {
        install(JsonFeature) {
            serializer = GsonSerializer()
        }
    }

    suspend fun getUser() = client.get<GenericUserDTO>("https://randomuser.me/api/?results=20") {
        headers {
            append("custom-header", "header-value")
        }
    }.results
}