package com.kotlinspring.coursecatalogueservice.service

import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class GreetingsService {

    @Value("\${message}")
    lateinit var message: String
    fun retrieveGreeting(name: String) = "Hello $name, $message"
}