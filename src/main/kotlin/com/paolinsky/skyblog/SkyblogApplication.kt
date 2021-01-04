package com.paolinsky.skyblog

import com.paolinsky.skyblog.utils.ConfigProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(ConfigProperties::class)
class SkyblogApplication

fun main(args: Array<String>) {
	runApplication<SkyblogApplication>(*args)
}
