package com.paolinsky.skyblog.repo

import com.paolinsky.skyblog.domain.Post
import org.springframework.data.repository.CrudRepository
import org.springframework.web.bind.annotation.PostMapping

interface IPostRepo : CrudRepository<Post, Int> {
    fun findBySlug(slug: String): Post?
    fun findAllByOrderByDate(): Iterable<Post>
    fun save(post: Post): Post?
}