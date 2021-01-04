package com.paolinsky.skyblog.api.api.entities

import com.fasterxml.jackson.annotation.JsonProperty
import com.paolinsky.skyblog.domain.Post

data class NewPostRequest(
    @JsonProperty
    val post: Post,
    @JsonProperty
    val secret: String
)