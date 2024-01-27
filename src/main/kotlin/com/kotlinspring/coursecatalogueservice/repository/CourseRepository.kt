package com.kotlinspring.coursecatalogueservice.repository

import com.kotlinspring.coursecatalogueservice.entity.Course
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface CourseRepository: CrudRepository<Course, Int> {

    fun findByNameContaining(courseName: String) :List<Course>

    @Query(value = "SELECT * FROM COURSES where name like %?1%", nativeQuery = true)
    fun findCoursesByName(courseName: String) :List<Course>
}