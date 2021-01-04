package com.paolinsky.skyblog.web

import com.paolinsky.skyblog.service.IPostService
import com.paolinsky.skyblog.service.imp.PostService
import org.commonmark.parser.Parser
import org.commonmark.renderer.html.AttributeProvider
import org.commonmark.renderer.html.AttributeProviderFactory
import org.commonmark.renderer.html.HtmlRenderer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller()
class MainController(
    @Autowired
    private val postService: PostService
) {
    private val mdParser = Parser.builder().build()
    private val htmlRenderer = HtmlRenderer.builder().build()

    @GetMapping("/")
    fun mainView(model: Model): String {
        return "main"
    }

    @GetMapping("/post/{slug}")
    fun getPostBySlug(@PathVariable slug: String, model: Model): String {
        val post = postService.getBySlug(slug)

        if (post != null){
            val postMarkdown = mdParser.parse(post.content)
            model.addAttribute("content", htmlRenderer.render(postMarkdown))
            model.addAttribute("title", post.title)
        } else
            return "notFound"
        return "postPage"
    }

    @GetMapping("/about")
    fun aboutView(): String { return "about" }
}
