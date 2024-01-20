package com.kotlinspring.coursecatalogueservice.service

import com.kotlinspring.coursecatalogueservice.dto.CourseDTO
import com.kotlinspring.coursecatalogueservice.entity.Course
import com.kotlinspring.coursecatalogueservice.exception.CourseNotFoundException
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

    fun updateCourse(courseId: Int, courseDTO: CourseDTO): CourseDTO {

        val existingCourse = courseRepository.findById(courseId)

        return if (existingCourse.isPresent) {
            existingCourse.get()
                .let {
                    it.category = courseDTO.category
                    it.name = courseDTO.name
                    courseRepository.save(it)
                    //  CourseDTO(it.id, it.name, it.category)
                    CourseDTO(it.id, it.name, it.category)
                }
        } else {
            throw CourseNotFoundException("No Course Found for the passed in Id $courseId")
        }

    }


}