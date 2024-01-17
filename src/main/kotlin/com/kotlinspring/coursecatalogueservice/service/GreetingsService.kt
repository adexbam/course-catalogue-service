package com.kotlinspring.coursecatalogueservice.service

import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable

@Service
class GreetingsService {

    fun retrieveGreeting(@PathVariable("name") name: String): String {
        return "Hello $name"
    }
}