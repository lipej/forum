package codes.lipe.forum.domain.repositories

import codes.lipe.forum.domain.entities.course.Course

interface ICourseRepository {
    abstract fun findById(id: String): Course
    abstract fun list(): List<Course>
    abstract fun create(course: Course): Course
    abstract fun delete(id: String)
    abstract fun update(course: Course)
}