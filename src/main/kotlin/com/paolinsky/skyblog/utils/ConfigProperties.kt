package com.paolinsky.skyblog.utils

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.stereotype.Service

@ConstructorBinding
@ConfigurationProperties(prefix = "app.config")
data class ConfigProperties(
    val secret: String
)