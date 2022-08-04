package codes.lipe.forum.infra.repositories.memory

import codes.lipe.forum.domain.entities.course.Course
import codes.lipe.forum.domain.repositories.ICourseRepository
import org.springframework.stereotype.Repository

@Repository
class CourseRepository(private val courses: MutableList<Course> = ArrayList()): ICourseRepository {
    override fun findById(id: String): Course {
        return courses.first { it.id.toString() == id }
    }

    override fun list(): List<Course> {
        return courses
    }

    override fun create(course: Course): Course {
        courses.add(course)

        return course
    }

    override fun delete(id: String) {
        courses.removeIf { it.id.toString() == id }
    }

    override fun update(course: Course) {
        this.delete(course.id.toString())
        this.courses.add(course)
    }
}