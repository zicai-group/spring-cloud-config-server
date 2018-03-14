package io.gitee.zicai.server.controller

import io.gite.zicai.domain.Published
import io.gitee.zicai.server.dao.PublishedDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/published")
open class PublishedController {

    @Autowired
    private lateinit var publishDao: PublishedDao

    @GetMapping("/save/{appName}")
    open fun save(@PathVariable appName: String) {
        appName.let { Published(appName = it) }.let(publishDao::insert)
    }

    @GetMapping("/last")
    open fun last(): Published? = publishDao.getLast()
}