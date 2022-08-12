package codes.lipe.forum.domain.services

import codes.lipe.forum.domain.dto.topic.CreateTopicDTO
import codes.lipe.forum.domain.entities.topic.Topic
import codes.lipe.forum.infra.repositories.memory.*
import org.springframework.stereotype.Service

@Service
class TopicService(
    private val topicRepo: TopicRepository,
    private val userRepo: UserRepository,
    private val courseRepo: CourseRepository
    ) {

    fun list(): List<Topic> {
        return topicRepo.list()
    }

    fun get(id: String): Topic {
        return topicRepo.findById(id)
    }

    fun create(dto: CreateTopicDTO, courseId: String): Topic {
        val user = userRepo.findById(dto.userId)
        val course = courseRepo.findById(courseId)

        return topicRepo.create(Topic(
            title = dto.title,
            message = dto.message,
            createdBy = user,
            course = course
        ))
    }
}