package codes.lipe.forum.domain.dto.user

data class CreateUserDTO(
    val name: String,
    val mail: String,
    val password: String,
)
