package io.gitee.zicai.server.controller

import io.gitee.zicai.biz.service.PublishedService
import io.gitee.zicai.core.common.BaseController
import io.gitee.zicai.core.feign.IPublishedFeign
import io.gitee.zicai.core.vo.ResultVO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController

@RestController
open class PublishedController : BaseController(), IPublishedFeign {

    @Autowired
    private lateinit var publishedService: PublishedService

    override fun publishedSave(appName: String?, profile: String?): ResultVO {
        return publishedService.insert(appName, profile).let(::result)
    }

    override fun publishedSave(appId: Long?): ResultVO {
        return publishedService.insert(appId).let(::result)
    }

    override fun publishedLast(appName: String?, profile: String?): ResultVO {
        return onSuccess(publishedService.getLast(appName, profile))
    }

    override fun publishedLast(appId: Long?): ResultVO {
        return onSuccess(publishedService.getLast(appId))
    }
}