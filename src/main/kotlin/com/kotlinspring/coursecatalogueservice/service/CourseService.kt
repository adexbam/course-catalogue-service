package com.kotlinspring.coursecatalogueservice.service

import com.kotlinspring.coursecatalogueservice.dto.CourseDTO
import com.kotlinspring.coursecatalogueservice.entity.Course
import com.kotlinspring.coursecatalogueservice.repository.CourseRepository
import org.springframework.stereotype.Service

@Service
class CourseService(val courseRepository: CourseRepository){

    fun addCourse(courseDTO: CourseDTO) : CourseDTO {

        val courseEntity = courseDTO.let {
            Course(null,it.name, it.category)
        }
        courseRepository.save(courseEntity)

        //logger.info { "Saved course is : $courseEntity" }

        return courseEntity.let {
            CourseDTO(it.id, it.name, it.category)
        }
    }



    fun retrieveAllCourses(): List<CourseDTO> {
        return courseRepository.findAll().map {
            CourseDTO(it.id, it.name, it.category)
        }
    }


}