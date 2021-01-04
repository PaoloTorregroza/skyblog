package com.paolinsky.skyblog.domain

import com.paolinsky.skyblog.utils.BlogUtils
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
data class Post(
    @Column(unique = true)
    var title: String,

    @Column(unique = true)
    var slug: String = BlogUtils.toSlug(title),

    @Column(length = 39570)
    var content: String,

    var date: LocalDateTime = LocalDateTime.now(),

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null
)