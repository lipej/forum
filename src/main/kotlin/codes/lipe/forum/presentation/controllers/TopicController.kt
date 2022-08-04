package codes.lipe.forum.presentation.controllers

import codes.lipe.forum.domain.dto.CreateTopicDTO
import codes.lipe.forum.domain.entities.topic.Topic
import codes.lipe.forum.domain.services.TopicService
import org.springframework.web.bind.annotation.*

@RestController()
@RequestMapping("/topics")
class TopicController(private val topicService: TopicService) {

    @GetMapping
    fun list(): List<Topic> {
        return topicService.list()
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id: String): Topic {
        return topicService.get(id)
    }

    @PostMapping
    fun create(@RequestBody topic: CreateTopicDTO) {
        topicService.create(topic)
    }
}