package codes.lipe.forum.presentation.controllers

import codes.lipe.forum.domain.dto.course.CreateCourseDTO
import codes.lipe.forum.domain.dto.course.ResponseCourseDTO
import codes.lipe.forum.domain.dto.course.UpdateCourseDTO
import codes.lipe.forum.domain.services.CourseService
import org.springframework.web.bind.annotation.*

@RestController()
@RequestMapping("/courses")
class CourseController(private val courseService: CourseService) {
    @GetMapping
    fun list(): List<ResponseCourseDTO> {
        return courseService.list().map { ResponseCourseDTO(it) }
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id: String): ResponseCourseDTO {
        return ResponseCourseDTO(courseService.get(id))
    }

    @PostMapping
    fun create(@RequestBody topic: CreateCourseDTO): ResponseCourseDTO {
        return ResponseCourseDTO(courseService.create(topic))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) {
        courseService.delete(id)
    }

    @PutMapping("/{id}")
    fun update(@RequestBody args: UpdateCourseDTO, @PathVariable id: String): ResponseCourseDTO {
        return ResponseCourseDTO(courseService.update(id, args))
    }
}