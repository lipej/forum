package codes.lipe.forum.domain.repositories

import codes.lipe.forum.domain.entities.user.User

interface IUserRepository {
    fun findById(id: String): User
    fun create(user: User): User
    fun delete(id: String)
    fun update(user: User)
}