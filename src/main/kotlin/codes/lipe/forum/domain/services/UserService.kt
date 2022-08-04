package codes.lipe.forum.domain.services

import codes.lipe.forum.domain.dto.CreateUserDTO
import codes.lipe.forum.domain.dto.UpdateUserDTO
import codes.lipe.forum.domain.entities.user.User
import codes.lipe.forum.infra.repositories.memory.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepo: UserRepository) {
    fun get(id: String): User {
        return userRepo.findById(id)
    }

    fun create(dto: CreateUserDTO): User {
        return userRepo.create(
            User(
            name = dto.name,
            mail = dto.mail
        )
        )
    }

    fun delete(id: String) {
        userRepo.delete(id)
    }

    fun update(id: String, args: UpdateUserDTO,) {
        val user = this.get(id).copy(name = args.name, mail = args.mail)
        userRepo.update(user)
    }

}
