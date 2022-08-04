package codes.lipe.forum.presentation.controllers

import codes.lipe.forum.domain.dto.*
import codes.lipe.forum.domain.entities.course.Course
import codes.lipe.forum.domain.services.CourseService
import org.springframework.web.bind.annotation.*

@RestController()
@RequestMapping("/courses")
class CourseController(private val courseService: CourseService) {
    @GetMapping
    fun list(): List<Course> {
        return courseService.list()
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id: String): Course {
        return courseService.get(id)
    }

    @PostMapping
    fun create(@RequestBody topic: CreateCourseDTO) {
        courseService.create(topic)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) {
        courseService.delete(id)
    }

    @PutMapping("/{id}")
    fun update(@RequestBody args: UpdateCourseDTO, @PathVariable id: String) {
        courseService.update(id, args)
    }
}