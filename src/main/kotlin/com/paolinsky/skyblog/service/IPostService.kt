package com.paolinsky.skyblog.service

import com.paolinsky.skyblog.domain.Post

interface IPostService {
    fun getAll(): Iterable<Post>
    fun getBySlug(slug: String): Post?
    fun save(post: Post): Post?
    fun remove(id: Int)
}