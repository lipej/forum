package codes.lipe.forum.infra.repositories.memory

import codes.lipe.forum.domain.entities.user.User
import codes.lipe.forum.domain.repositories.IUserRepository
import org.springframework.stereotype.Repository

@Repository
class UserRepository(private val users: MutableList<User> = ArrayList()): IUserRepository {
    override fun findById(id: String): User {
        return users.first { it.id.toString() == id }
    }

    override fun create(user: User): User {
        users.add(user)

        return user
    }

    override fun delete(id: String) {
        users.removeIf { it.id.toString() == id }
    }

    override fun update(user: User) {
        this.delete(user.id.toString())
        this.users.add(user)
    }
}