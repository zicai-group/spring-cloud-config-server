package io.gitee.zicai.core.feign

import io.gitee.zicai.core.vo.ResultVO
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam

interface IAppPropsFeign {

    companion object {
        const val PREFIX = "/props"
    }

    @GetMapping("$PREFIX/get/{appName}/{profile}")
    fun propsGet(@PathVariable("appName") appName: String, @PathVariable("profile") profile: String): ResultVO

    @GetMapping("$PREFIX/add/{appId}")
    fun propsAdd(@PathVariable("appId") appId: Long, @RequestParam("k") k: String, @RequestParam("v") v: String): ResultVO

    @GetMapping("$PREFIX/del/{id}")
    fun propsDel(@PathVariable("id") id: Long): ResultVO

    @GetMapping("$PREFIX/page/{index}/{size}")
    fun propsPage(@PathVariable("index") index: Int?, @PathVariable("size") size: Int?): ResultVO
}
