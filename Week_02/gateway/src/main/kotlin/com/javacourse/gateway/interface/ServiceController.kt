package com.javacourse.gateway.`interface`

import com.javacourse.gateway.ServiceClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class ServiceController(val serviceClient: ServiceClient) {

    @GetMapping("/service")
    fun service(): String {
        return serviceClient.request()
    }
}