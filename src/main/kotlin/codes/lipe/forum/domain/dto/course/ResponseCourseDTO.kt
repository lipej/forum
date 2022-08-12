package codes.lipe.forum.domain.dto.course

import codes.lipe.forum.domain.entities.course.Course

class ResponseCourseDTO(course: Course) {
    val id: String = course.id.toString()
    val name: String = course.name
    val category: String = course.category
}
