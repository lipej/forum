package codes.lipe.forum.presentation.controllers

import codes.lipe.forum.domain.dto.topic.BasicResponseTopicDTO
import codes.lipe.forum.domain.dto.topic.CreateTopicDTO
import codes.lipe.forum.domain.entities.topic.Topic
import codes.lipe.forum.domain.services.TopicService
import org.springframework.web.bind.annotation.*

@RestController()
@RequestMapping("/topics")
class TopicController(private val topicService: TopicService) {

    @GetMapping
    fun list(): List<BasicResponseTopicDTO> {
        return topicService.list().map { BasicResponseTopicDTO(it) }
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id: String): Topic {
        return topicService.get(id)
    }

    @PostMapping("/{courseId}")
    fun create(@RequestBody topic: CreateTopicDTO, @PathVariable courseId: String): BasicResponseTopicDTO {
        return BasicResponseTopicDTO(topicService.create(topic, courseId))
    }
}