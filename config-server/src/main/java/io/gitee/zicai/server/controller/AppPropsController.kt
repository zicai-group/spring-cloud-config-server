package io.gitee.zicai.server.controller

import io.gitee.zicai.biz.service.AppPropsService
import io.gitee.zicai.core.common.BaseController
import io.gitee.zicai.core.entity.AppProps
import io.gitee.zicai.core.feign.IAppPropsFeign
import io.gitee.zicai.core.vo.ResultVO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController

@RestController
open class AppPropsController : BaseController(), IAppPropsFeign {

    @Autowired
    private lateinit var appPropsService: AppPropsService

    override fun propsGet(appName: String, profile: String): ResultVO {
        return onSuccess(appPropsService.findProps(appName, profile))
    }

    override fun propsAdd(appId: Long, k: String, v: String): ResultVO {
        return AppProps().also {
            it.appId = appId
            it.propKey = k
            it.propValue = v
        }.let { appPropsService.insert(it) }.let(::result)
    }

    override fun propsDel(id: Long): ResultVO {
        return appPropsService.deleteByPrimaryKey(id).let(::result)
    }

    override fun propsPage(index: Int?, size: Int?): ResultVO {
        return onSuccess(appPropsService.page(index ?: 1, size ?: 10))
    }
}