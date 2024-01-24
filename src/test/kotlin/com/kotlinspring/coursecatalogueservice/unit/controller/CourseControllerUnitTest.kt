package com.kotlinspring.coursecatalogueservice.unit.controller

import com.kotlinspring.coursecatalogueservice.controller.CourseController
import com.kotlinspring.coursecatalogueservice.dto.CourseDTO
import com.kotlinspring.coursecatalogueservice.service.CourseService
import com.ninjasquad.springmockk.MockkBean
import courseDTO
import io.mockk.every
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient

@WebMvcTest(CourseController::class)
@AutoConfigureWebTestClient
class CourseControllerUnitTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @MockkBean
    lateinit var courseServiceMock: CourseService

    @Test
    fun addCourse() {
        //given
        val courseDTO = CourseDTO(null, "Build Restful APIs using springBoot and Kotlin", "ade")

        every { courseServiceMock.addCourse(any()) } returns courseDTO(id=1)

        //when
        val savedCourseDTO = webTestClient
            .post()
            .uri("/v1/courses")
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(courseDTO)
            .exchange()
            .expectStatus().isCreated
            .expectBody(CourseDTO::class.java)
            .returnResult()
            .responseBody

        //then
        Assertions.assertTrue {
            savedCourseDTO!!.id != null
        }
    }

    @Test
    fun retrieveAllCourses() {

        every { courseServiceMock.retrieveAllCourses() }.returnsMany(
            listOf(
                courseDTO(1,
                    "Build RestFul APis using Spring Boot and Kotlin", "Development"),
                courseDTO(2,
                    "Build Reactive Microservices using Spring WebFlux/SpringBoot", "Development")
            )
        )


        val courseDTOs = webTestClient
            .get()
            .uri("/v1/courses")
            .exchange()
            .expectStatus().isOk
            .expectBodyList(CourseDTO::class.java)
            .returnResult()
            .responseBody

        println("courseDTOs : $courseDTOs")

        Assertions.assertEquals(2, courseDTOs!!.size)

    }



}