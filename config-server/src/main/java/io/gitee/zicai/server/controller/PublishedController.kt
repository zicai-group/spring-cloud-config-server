package io.gitee.zicai.server.controller

import io.gitee.zicai.biz.service.PublishedService
import io.gitee.zicai.core.common.BaseController
import io.gitee.zicai.core.feign.IPublishedFeign
import io.gitee.zicai.core.vo.ResultVO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
open class PublishedController : BaseController(), IPublishedFeign {

    @Autowired
    private lateinit var publishedService: PublishedService

    override fun publishedSave(@PathVariable("appName") appName: String?, @PathVariable("profile") profile: String?): ResultVO {
        return publishedService.insert(appName, profile).let(::result)
    }

    override fun publishedSave(@PathVariable("appId") appId: Long?): ResultVO {
        return publishedService.insert(appId).let(::result)
    }

    override fun publishedLast(@PathVariable("appName") appName: String?, @PathVariable("profile") profile: String?): ResultVO {
        return onSuccess(publishedService.getLast(appName, profile))
    }

    override fun publishedLast(@PathVariable("appId") appId: Long?): ResultVO {
        return onSuccess(publishedService.getLast(appId))
    }
}