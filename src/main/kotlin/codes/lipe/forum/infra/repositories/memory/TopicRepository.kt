package codes.lipe.forum.infra.repositories.memory

import codes.lipe.forum.domain.entities.course.Course
import codes.lipe.forum.domain.entities.topic.Topic
import codes.lipe.forum.domain.entities.user.User
import codes.lipe.forum.domain.enums.TopicState
import codes.lipe.forum.domain.repositories.ITopicRepository
import codes.lipe.forum.infra.repositories.memory.models.TopicModel
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class TopicRepository : ITopicRepository {

    override fun findById(id: String): Topic {
        val topicModel = Db.topics.stream().filter { it.id == id }.findFirst().get()

        return toEntity(topicModel)
    }

    override fun list(): List<Topic> {
        return Db.topics.map { toEntity(it) }
    }

    override fun create(topic: Topic): Topic {
        Db.topics.add(TopicModel(
            id = topic.id.toString(),
            title = topic.title,
            message = topic.message,
            createdAt = topic.createdAt,
            createdBy = topic.createdBy.id.toString(),
            status = topic.status.toString(),
            courseId = topic.course.id.toString()
        ))

        println(Db.topics)

        return topic
    }

    private fun toEntity(topicModel: TopicModel): Topic {
        val userModel = Db.users.stream().filter { it.id == topicModel.createdBy }.findFirst().get()
        val courseModel = Db.courses.stream().filter { it.id == topicModel.courseId }.findFirst().get()

        return Topic(
            id = UUID.fromString(topicModel.id),
            title = topicModel.title,
            message = topicModel.message,
            status = TopicState.valueOf(topicModel.status),
            createdAt = topicModel.createdAt,
            createdBy = User(
                id = UUID.fromString(userModel.id),
                name = userModel.name,
                mail = userModel.mail,
                password = userModel.password,
            ),
            course = Course(
                id = UUID.fromString(courseModel.id),
                name = courseModel.name,
                category = courseModel.category,
            ),
        )
    }
}