package codes.lipe.forum.presentation.controllers

import codes.lipe.forum.domain.dto.user.CreateUserDTO
import codes.lipe.forum.domain.dto.user.ResponseUserDTO
import codes.lipe.forum.domain.dto.user.UpdateUserDTO
import codes.lipe.forum.domain.services.UserService
import org.springframework.web.bind.annotation.*

@RestController()
@RequestMapping("/users")
class UserController(private val userService: UserService) {
    @GetMapping("/{id}")
    fun get(@PathVariable id: String): ResponseUserDTO {
        return ResponseUserDTO(userService.get(id))
    }

    @PostMapping
    fun create(@RequestBody topic: CreateUserDTO): ResponseUserDTO {
        return ResponseUserDTO(userService.create(topic))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) {
        userService.delete(id)
    }

    @PutMapping("/{id}")
    fun update(@RequestBody args: UpdateUserDTO, @PathVariable id: String) {
        userService.update(id, args)
    }
}