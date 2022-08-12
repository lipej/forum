package codes.lipe.forum.domain.dto.topic

import codes.lipe.forum.domain.entities.topic.Topic

class BasicResponseTopicDTO(topic: Topic) {
    val id: String = topic.id.toString()
    val title: String = topic.title
    val status: String = topic.status.toString()
    val courseId: String = topic.course.id.toString()
    val createdBy: String = topic.createdBy.id.toString()
    val createdAt: String = topic.createdAt.toString()
}