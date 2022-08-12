package codes.lipe.forum.domain.repositories

import codes.lipe.forum.domain.entities.course.Course

interface ICourseRepository {
    fun findById(id: String): Course
    fun list(): List<Course>
    fun create(course: Course): Course
    fun delete(id: String)
    fun update(course: Course): Course
}