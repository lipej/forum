package codes.lipe.forum.domain.repositories

import codes.lipe.forum.domain.entities.topic.Topic

interface ITopicRepository {
    fun findById(id: String): Topic
    fun list(): List<Topic>
    fun create(topic: Topic): Topic
}