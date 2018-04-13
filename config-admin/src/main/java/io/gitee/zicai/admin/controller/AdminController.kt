package io.gitee.zicai.admin.controller

import io.gitee.zicai.admin.service.IFeignService
import io.gitee.zicai.core.common.BaseController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin")
open class AdminController : BaseController() {

    @Autowired
    private lateinit var feignService: IFeignService

    /* =========== app service begin =========== */

    @GetMapping("/app/get/{appName}/{profile}")
    open fun appGet(@PathVariable("appName")appName: String, @PathVariable("profile")profile: String) = feignService.appGet(appName, profile)

    @GetMapping("/app/add/{appName}/{profile}")
    open fun appAdd(@PathVariable("appName")appName: String, @PathVariable("profile")profile: String) = feignService.appAdd(appName, profile)

    @GetMapping("/app/del/{id}")
    open fun appDel(@PathVariable("id")id: Long) = feignService.appDel(id)

    @GetMapping("/app/page/{index}/{size}")
    open fun appPage(@PathVariable("index")index: Int, @PathVariable("size")size: Int) = feignService.appPage(index, size)

    /* =========== app service end   =========== */

    /* =========== props service begin =========== */

    @GetMapping("/props/get/{appName}/{profile}")
    open fun propsGet(@PathVariable("appName")appName: String, @PathVariable("profile")profile: String) = feignService.propsGet(appName, profile)

    @GetMapping("/props/add/{appId}")
    open fun propsAdd(@PathVariable("appId")appId: Long, k: String, v: String) = feignService.propsAdd(appId, k, v)

    @GetMapping("/props/del/{id}")
    open fun propsDel(@PathVariable("id")id: Long) = feignService.propsDel(id)

    @GetMapping("/props/page/{index}/{size}")
    open fun propsPage(@PathVariable("index")index: Int, @PathVariable("size")size: Int) = feignService.propsPage(index, size)

    /* =========== props service end   =========== */

    /* =========== published service begin =========== */

    @GetMapping("/published/save/{appName}/{profile}")
    open fun publishedSave(@PathVariable("appName")appName: String, @PathVariable("profile")profile: String) = feignService.publishedSave(appName, profile)

    @GetMapping("/published/save/{appId}")
    open fun publishedSave(@PathVariable("appId")appId: Long) = feignService.publishedSave(appId)

    @GetMapping("/published/last/{appName}/{profile}")
    open fun publishedLast(@PathVariable("appName")appName: String, @PathVariable("profile")profile: String) = feignService.publishedLast(appName, profile)

    @GetMapping("/published/last/{appId}")
    open fun publishedLast(@PathVariable("appId")appId: Long) = feignService.publishedLast(appId)

    /* =========== published service end   =========== */
}