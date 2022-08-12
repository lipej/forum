package codes.lipe.forum.domain.entities.user

import java.util.UUID

data class User (
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val mail: String,
    val password: String
)