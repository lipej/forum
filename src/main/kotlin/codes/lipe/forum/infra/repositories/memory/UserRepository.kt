package codes.lipe.forum.infra.repositories.memory

import codes.lipe.forum.domain.entities.user.User
import codes.lipe.forum.domain.repositories.IUserRepository
import codes.lipe.forum.infra.repositories.memory.models.UserModel
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class UserRepository : IUserRepository {
    override fun findById(id: String): User {
        return toEntity(Db.users.first { it.id == id })
    }

    override fun create(user: User): User {
        Db.users.add(UserModel(
            id = user.id.toString(),
            name = user.name,
            mail = user.mail,
            password = user.password
        ))

        return user
    }

    override fun delete(id: String) {
        Db.users.removeIf { it.id == id }
    }

    override fun update(user: User) {
        this.delete(user.id.toString())
        this.create(user)
    }

    private fun toEntity(model: UserModel): User {
        return User(
                id = UUID.fromString(model.id),
                name = model.name,
                mail = model.mail,
                password = model.password
        )
    }
}