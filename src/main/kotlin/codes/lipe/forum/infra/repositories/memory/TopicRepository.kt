package codes.lipe.forum.infra.repositories.memory

import codes.lipe.forum.domain.entities.topic.Topic
import codes.lipe.forum.domain.repositories.ITopicRepository
import org.springframework.stereotype.Repository

@Repository
class TopicRepository(private val topics: MutableList<Topic> = ArrayList()): ITopicRepository {

    override fun findById(id: String): Topic {
        return topics.stream().filter { it.id.toString() == id }.findFirst().get()
    }

    override fun list(): List<Topic> {
        return topics
    }

    override fun create(topic: Topic): Topic {
        topics.add(topic)

        return topic
    }


}