package codes.lipe.forum.domain.dto.topic

data class CreateTopicDTO(
    val title: String,
    val message: String,
    val userId: String
)
