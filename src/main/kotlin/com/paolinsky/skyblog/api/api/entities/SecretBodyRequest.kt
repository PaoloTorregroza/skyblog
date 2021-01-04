package com.paolinsky.skyblog.api.api.entities

import com.fasterxml.jackson.annotation.JsonProperty

data class SecretBodyRequest (
    @JsonProperty
    val secret: String
)