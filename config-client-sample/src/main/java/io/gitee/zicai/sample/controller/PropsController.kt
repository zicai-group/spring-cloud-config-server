package io.gitee.zicai.sample.controller

import io.gitee.zicai.sample.service.PropService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/props")
@RestController
open class PropsController {

    @Autowired
    private lateinit var propService: PropService

    @GetMapping("/get")
    open fun getProps() = propService.getProps()
}