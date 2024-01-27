package com.kotlinspring.coursecatalogueservice.intg.repository

import com.kotlinspring.coursecatalogueservice.repository.CourseRepository
import courseEntityList
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class CourseRepositoryIntgTest {

    @Autowired
    lateinit var courseRepository: CourseRepository

    @BeforeEach
    fun setup(){

        courseRepository.deleteAll()
        val courses = courseEntityList()
        courseRepository.saveAll(courses)
    }

    @Test
    fun findByNameContaining() {
        val courses = courseRepository.findByNameContaining("SpringBoot")
        println("courses : $courses")

        Assertions.assertEquals(2, courses.size)
    }
}