package codes.lipe.forum.domain.entities.topic

import codes.lipe.forum.domain.entities.user.User
import codes.lipe.forum.domain.entities.course.Course
import codes.lipe.forum.domain.enums.TopicState
import java.time.LocalDateTime
import java.util.UUID

data class Topic (
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val message: String,
    val status: TopicState = TopicState.WAITING_RESPONSE,
    val course: Course,
    val responses: List<TopicResponse> = ArrayList(),
    val createdBy: User,
    val createdAt: LocalDateTime = LocalDateTime.now()
)