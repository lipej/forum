package codes.lipe.forum.presentation.controllers

import codes.lipe.forum.domain.dto.*
import codes.lipe.forum.domain.entities.user.User
import codes.lipe.forum.domain.services.UserService
import org.springframework.web.bind.annotation.*

@RestController()
@RequestMapping("/users")
class UserController(private val userService: UserService) {
    @GetMapping("/{id}")
    fun get(@PathVariable id: String): User {
        return userService.get(id)
    }

    @PostMapping
    fun create(@RequestBody topic: CreateUserDTO): String {
        return userService.create(topic).id.toString()
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