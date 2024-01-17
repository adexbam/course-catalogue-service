package com.kotlinspring.coursecatalogueservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CourseCatalogueServiceApplication

fun main(args: Array<String>) {
	runApplication<CourseCatalogueServiceApplication>(*args)
}
