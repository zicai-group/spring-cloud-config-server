package io.gitee.zicai.jooq.controller

import io.gitee.zicai.core.common.BaseController
import io.gitee.zicai.core.vo.ResultVO
import io.gitee.zicai.jooq.service.AppService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * AppController
 *
 * @author zicai
 * @since 2018-08-13
 */
@RestController
@RequestMapping("/app")
open class AppController : BaseController() {

    @Autowired
    private lateinit var appService: AppService

    @GetMapping("/get/{appName}/{profile}")
    fun appGet(@PathVariable("appName") appName: String, @PathVariable("profile") profile: String): ResultVO {
        return onSuccess(appService.findOne(appName, profile))
    }
}