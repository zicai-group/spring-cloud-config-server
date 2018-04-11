package io.gitee.zicai.server.controller

import io.gitee.zicai.biz.service.PublishedService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/published")
open class PublishedController {

    @Autowired
    private lateinit var publishedService: PublishedService

    @GetMapping("/save/{appName}/{profile}")
    open fun save(@PathVariable appName: String, @PathVariable profile: String) {
        publishedService.insert(appName, profile)
    }

    @GetMapping("/last/{appName}/{profile}")
    open fun last(@PathVariable appName: String, @PathVariable profile: String) = publishedService.getLast(appName, profile)
}