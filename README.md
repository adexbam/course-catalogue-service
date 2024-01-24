# course-catalogue-service
Project Description: A course catalogue service created with Kotlin and spring boot, The service is a restful api that manages the course catalogue for an online learning platform. A postgres DB will be used to store the course information.  

key features: 
- Allows all available courses to be retrieved 
- Allows a course to be added
- Allows a course to be updated
- Allows a course to be deleted

Installation: It's best to clone the repository, you can use the git clone command followed by the URL of the repository. Here are the general steps:
1. Navigate to the main page of the repository on GitHub.
2. Click on the "Code" button.
3. Copy the URL for the repository.
Then, in your terminal, use the following command:
`https://github.com/adexbam/course-catalogue-service.git`

prerequisites:
- Java 17 is Required
Experience working with any IDE( Intellij, Eclipse)
Experience working with Kotlin/Java
Experience building application using SpringBoot
Gradle or Maven Build tool Experience is must

Endpoints:
GET `http://localhost:8080/v1/courses`
POST `http://localhost:8080/v1/courses`
PUT `http://localhost:8080/v1/courses/{courseId}`
DELETE `http://localhost:8080/v1/courses/{courseId}`

Usage:The project can be used by making a call to the endpoints via postman the terminal or on the client side.


H2 Database: 
Access the h2 database in the following link - http://localhost:8080/h2-console