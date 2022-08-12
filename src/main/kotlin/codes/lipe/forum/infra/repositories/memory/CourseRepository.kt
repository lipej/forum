package codes.lipe.forum.infra.repositories.memory

import codes.lipe.forum.domain.entities.course.Course
import codes.lipe.forum.domain.repositories.ICourseRepository
import codes.lipe.forum.infra.repositories.memory.models.CourseModel
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class CourseRepository : ICourseRepository {
    override fun findById(id: String): Course {
        return toEntity(Db.courses.first { it.id == id })
    }

    override fun list(): List<Course> {
        return Db.courses.map { toEntity(it) }
    }

    override fun create(course: Course): Course {
        Db.courses.add(CourseModel(
            id = course.id.toString(),
            name = course.name,
            category = course.category,
        ))

        return course
    }

    override fun delete(id: String) {
        Db.courses.removeIf { it.id == id }
    }

    override fun update(course: Course): Course {
        delete(course.id.toString())
        return create(course)
    }

    private fun toEntity(course: CourseModel): Course {
        return Course(
            id = UUID.fromString(course.id),
            name = course.name,
            category = course.category,
        )
    }
}