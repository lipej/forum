package codes.lipe.forum.infra.repositories.memory

import codes.lipe.forum.infra.repositories.memory.models.*

class Db {
    companion object {
        val topics: MutableList<TopicModel> = ArrayList()
        val users: MutableList<UserModel> = ArrayList()
        val courses: MutableList<CourseModel> = ArrayList()
    }
}
