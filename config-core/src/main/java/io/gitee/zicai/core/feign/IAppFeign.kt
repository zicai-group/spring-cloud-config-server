package io.gitee.zicai.core.feign

import io.gitee.zicai.core.vo.ResultVO
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

interface IAppFeign {

    companion object {
        const val PREFIX = "/app"
    }

    @GetMapping("$PREFIX/get/{appName}/{profile}")
    fun appGet(@PathVariable("appName") appName: String, @PathVariable("profile") profile: String): ResultVO

    @GetMapping("$PREFIX/add/{appName}/{profile}")
    fun appAdd(@PathVariable("appName") appName: String, @PathVariable("profile") profile: String): ResultVO

    @GetMapping("$PREFIX/del/{id}")
    fun appDel(@PathVariable("id") id: Long): ResultVO

    @GetMapping("$PREFIX/page/{index}/{size}")
    fun appPage(@PathVariable("index") index: Int?, @PathVariable("size") size: Int?): ResultVO
}
