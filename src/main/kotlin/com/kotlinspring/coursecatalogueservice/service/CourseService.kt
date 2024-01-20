package com.kotlinspring.coursecatalogueservice.service

import com.kotlinspring.coursecatalogueservice.dto.CourseDTO
import com.kotlinspring.coursecatalogueservice.entity.Course
import com.kotlinspring.coursecatalogueservice.repository.CourseRepository
import mu.KLogging
import org.springframework.stereotype.Service

@Service
class CourseService(val courseRepository: CourseRepository) {

    companion object : KLogging()
    fun addCourse(courseDTO: CourseDTO) : CourseDTO {

        val courseEntity = courseDTO.let {
            Course(null,it.name, it.category)
        }
        courseRepository.save(courseEntity)

        logger.info { "Saved course is : $courseEntity" }

        return courseEntity.let {
            CourseDTO(it.id, it.name, it.category)
        }
    }
}
