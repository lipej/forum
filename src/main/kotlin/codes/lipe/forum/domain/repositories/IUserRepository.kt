package codes.lipe.forum.domain.repositories

import codes.lipe.forum.domain.entities.user.User

interface IUserRepository {
    abstract fun findById(id: String): User
    abstract fun create(user: User): User
    abstract fun delete(id: String)
    abstract fun update(user: User)
}