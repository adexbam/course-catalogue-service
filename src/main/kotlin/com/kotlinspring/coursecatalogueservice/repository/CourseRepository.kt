package com.kotlinspring.coursecatalogueservice.repository

import com.kotlinspring.coursecatalogueservice.entity.Course
import org.springframework.data.repository.CrudRepository

interface CourseRepository: CrudRepository<Course, Int> {
}