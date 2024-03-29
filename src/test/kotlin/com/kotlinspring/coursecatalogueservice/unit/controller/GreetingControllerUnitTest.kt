package com.kotlinspring.coursecatalogueservice.unit.controller

import com.kotlinspring.coursecatalogueservice.controller.GreetingController
import com.kotlinspring.coursecatalogueservice.service.GreetingService
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.reactive.server.WebTestClient

@WebMvcTest(controllers = [GreetingController::class])
@AutoConfigureWebTestClient
class GreetingControllerUnitTest {

    @MockkBean
    lateinit var greetingServiceMock: GreetingService

    @Autowired
    lateinit var webTestClient: WebTestClient


    @Test
    fun retrieveGreeting() {

        val name = "Ade"

        every { greetingServiceMock.retrieveGreeting(any()) } returns  "Hello $name, Hello from default profile"

        val result =webTestClient.get()
            .uri("/v1/greetings/{name}", name)
            .exchange()
            .expectStatus().is2xxSuccessful
            .expectBody(String::class.java)
            .returnResult()

        assertEquals("Hello $name, Hello from default profile", result.responseBody)

    }
}