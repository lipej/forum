package codes.lipe.forum.domain.services

import codes.lipe.forum.domain.dto.course.CreateCourseDTO
import codes.lipe.forum.domain.dto.course.UpdateCourseDTO
import codes.lipe.forum.domain.entities.course.Course
import codes.lipe.forum.infra.repositories.memory.CourseRepository
import org.springframework.stereotype.Service

@Service
class CourseService(private val courseRepo: CourseRepository) {
    fun get(id: String): Course {
        return courseRepo.findById(id)
    }

    fun create(dto: CreateCourseDTO): Course {
        return courseRepo.create(
            Course(
            name = dto.name,
                category = dto.category)
        )
    }

    fun delete(id: String) {
        courseRepo.delete(id)
    }

    fun update(id: String, args: UpdateCourseDTO): Course {
        val course = this.get(id).copy(name = args.name)
        return courseRepo.update(course)
    }

    fun list(): List<Course> {
        return courseRepo.list()
    }

}
