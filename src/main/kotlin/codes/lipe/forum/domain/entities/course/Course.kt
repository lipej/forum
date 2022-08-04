package codes.lipe.forum.domain.entities.course

import java.util.UUID

data class Course (
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val category: String
)