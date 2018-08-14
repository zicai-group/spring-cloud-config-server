package io.gitee.zicai.jpa.controller

import io.gitee.zicai.core.common.BaseController
import io.gitee.zicai.core.vo.ResultVO
import io.gitee.zicai.jpa.service.PublishedService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * PublishedController
 *
 * @author zicai
 * @since 2018-08-13
 */
@RestController
@RequestMapping("/published")
open class PublishedController : BaseController() {

    @Autowired
    private lateinit var publishedService: PublishedService

    @GetMapping("/last/{appName}/{profile}")
    open fun publishedLast(@PathVariable("appName") appName: String, @PathVariable("profile") profile: String): ResultVO {
        return onSuccess(publishedService.getLast(appName, profile))
    }

    @GetMapping("/last/{appId}")
    open fun publishedLast(@PathVariable("appId") appId: Long): ResultVO {
        return onSuccess(publishedService.getLast(appId))
    }
}