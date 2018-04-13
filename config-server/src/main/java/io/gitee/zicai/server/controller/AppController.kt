package io.gitee.zicai.server.controller

import io.gitee.zicai.biz.service.AppService
import io.gitee.zicai.core.common.BaseController
import io.gitee.zicai.core.entity.App
import io.gitee.zicai.core.feign.IAppFeign
import io.gitee.zicai.core.vo.ResultVO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController

@RestController
open class AppController : BaseController(), IAppFeign {

    @Autowired
    private lateinit var appService: AppService

    override fun appGet(appName: String, profile: String): ResultVO {
        return onSuccess(appService.findOne(appName, profile))
    }

    override fun appAdd(appName: String, profile: String): ResultVO {
        return App().also {
            it.appName = appName
            it.appEnv = profile
        }.let { appService.insert(it) }.let(::result)
    }

    override fun appDel(id: Long): ResultVO {
        return appService.deleteByPrimaryKey(id).let(::result)
    }

    override fun appPage(index: Int?, size: Int?): ResultVO {
        return onSuccess(appService.page(index ?: 1, size ?: 10))
    }
}