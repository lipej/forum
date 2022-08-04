package codes.lipe.forum.domain.repositories

import codes.lipe.forum.domain.entities.topic.Topic

interface ITopicRepository {
    abstract fun findById(id: String): Topic
    abstract fun list(): List<Topic>
    abstract fun create(topic: Topic): Topic
}