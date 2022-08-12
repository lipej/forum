package codes.lipe.forum.infra.repositories.memory.models

data class UserModel(
    val id: String,
    val name: String,
    val mail: String,
    val password: String,
)
