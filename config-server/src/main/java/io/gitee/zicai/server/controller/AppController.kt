package io.gitee.zicai.server.controller

import io.gitee.zicai.biz.service.AppPropsService
import io.gitee.zicai.biz.service.AppService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/app")
open class AppController {

    @Autowired
    private lateinit var appPropsService: AppPropsService

    @GetMapping("/props/{appName}/{profile}")
    open fun props(@PathVariable appName: String, @PathVariable profile: String) = appPropsService.findProps(appName, profile)

    @Autowired
    private lateinit var appService: io.gitee.zicai.biz.service.AppService

    @GetMapping("/get/{appName}/{profile}")
    open fun get(@PathVariable appName: String, @PathVariable profile: String) = appService.findOne(appName, profile)
}