package codes.lipe.forum.domain.dto.topic

import codes.lipe.forum.domain.dto.course.ResponseCourseDTO
import codes.lipe.forum.domain.dto.user.ResponseUserDTO
import codes.lipe.forum.domain.entities.topic.Topic
import codes.lipe.forum.domain.entities.topic.TopicResponse
import java.time.LocalDateTime

class ResponseTopicDTO(topic: Topic) {
    val id: String = topic.id.toString()
    val title: String = topic.title
    val message: String = topic.message
    val status: String = topic.status.toString()
    val responses: List<TopicResponse> = topic.responses
    val createdAt: LocalDateTime = topic.createdAt
    val createdBy: ResponseUserDTO = ResponseUserDTO(topic.createdBy)
    val course: ResponseCourseDTO = ResponseCourseDTO(topic.course)
}