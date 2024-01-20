package com.kotlinspring.coursecatalogueservice.entity

import jakarta.persistence.*

@Entity
@Table(name = "Course")
data class Course(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int?,
    var name : String,
    var category: String
)