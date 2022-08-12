package codes.lipe.forum.infra.repositories.memory.models

import java.time.LocalDateTime

data class TopicModel(
    val id: String,
    val title: String,
    val message: String,
    val status: String,
    val courseId: String,
    val createdBy: String,
    val createdAt: LocalDateTime
    )
