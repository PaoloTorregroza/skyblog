package com.paolinsky.skyblog.service.imp

import com.paolinsky.skyblog.domain.Post
import com.paolinsky.skyblog.repo.IPostRepo
import com.paolinsky.skyblog.service.IPostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PostService(
    @Autowired
    private val postRepo: IPostRepo
) : IPostService {
    override fun getAll(): Iterable<Post> {
        return postRepo.findAll()
    }

    override fun getBySlug(slug: String): Post? {
        return postRepo.findBySlug(slug)
    }

    override fun save(post: Post): Post? {
        return postRepo.save(post)
    }

    override fun remove(id: Int) {
        postRepo.deleteById(id)
    }
}