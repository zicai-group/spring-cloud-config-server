package io.gitee.zicai.jpa.controller

import io.gitee.zicai.core.common.BaseController
import io.gitee.zicai.core.vo.ResultVO
import io.gitee.zicai.jpa.service.AppPropsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * AppPropsController
 *
 * @author zicai
 * @since 2018-08-13
 */
@RestController
@RequestMapping("/props")
open class AppPropsController : BaseController() {

    @Autowired
    private lateinit var appPropsService: AppPropsService

    @GetMapping("/get/{appName}/{profile}")
    open fun propsGet(@PathVariable("appName") appName: String, @PathVariable("profile") profile: String): ResultVO {
        return onSuccess(appPropsService.findProps(appName, profile))
    }
}