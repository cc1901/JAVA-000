package com.javacourse.gateway

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class ServiceClient(val webClient: WebClient) {
    fun request(): String {
        val response = webClient.get().exchange().block()
        return response.toString()
    }
}