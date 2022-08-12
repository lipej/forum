package codes.lipe.forum.domain.dto.user

import codes.lipe.forum.domain.entities.user.User

class ResponseUserDTO(user: User) {
    val id: String = user.id.toString()
    val name: String = user.name
    val mail: String = user.mail
}