package com.paolinsky.skyblog.api

import com.paolinsky.skyblog.api.api.entities.NewPostRequest
import com.paolinsky.skyblog.api.api.entities.SecretBodyRequest
import com.paolinsky.skyblog.domain.Post
import com.paolinsky.skyblog.utils.ConfigProperties
import com.paolinsky.skyblog.service.imp.PostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController()
class PostsApiController(
    @Autowired
    private val postService: PostService,
    private val configProps: ConfigProperties
) {
    @GetMapping("api/posts")
    fun getAll(): Iterable<Post> {
        return postService.getAll()
    }

    @PostMapping("api/posts")
    fun save(@RequestBody postRequest: NewPostRequest): Post? {
        if (postRequest.secret == configProps.secret)
            return postService.save(postRequest.post)
        else throw ResponseStatusException(HttpStatus.UNAUTHORIZED, "Don't try it again")
    }

    @DeleteMapping("api/posts/{id}")
    fun remove(@PathVariable id: Int, @RequestBody req: SecretBodyRequest) {
        if (req.secret == configProps.secret)
            return postService.remove(id)
        else throw ResponseStatusException(HttpStatus.UNAUTHORIZED, "Don't try it again")
    }
}