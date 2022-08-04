package codes.lipe.forum.domain.dto

data class CreateTopicDTO(
    val title: String,
    val message: String,
    val courseId: String,
    val userId: String
)
