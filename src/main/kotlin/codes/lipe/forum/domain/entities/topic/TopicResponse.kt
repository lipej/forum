package codes.lipe.forum.domain.entities.topic

import codes.lipe.forum.domain.entities.user.User
import java.time.LocalDateTime
import java.util.UUID

data class TopicResponse (
    val id: UUID = UUID.randomUUID(),
    val message: String,
    val topic: Topic,
    val solution: Boolean = false,
    val createdBy: User,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    )
