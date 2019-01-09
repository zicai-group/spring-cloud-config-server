package io.gitee.zicai.core.feign

import io.gitee.zicai.core.vo.ResultVO
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

interface IPublishedFeign {

    companion object {
        const val PREFIX = "/published"
    }

    @GetMapping("$PREFIX/save/{appName}/{profile}")
    fun publishedSave(@PathVariable("appName") appName: String, @PathVariable("profile") profile: String): ResultVO

    @GetMapping("$PREFIX/save/{appId}")
    fun publishedSave(@PathVariable("appId") appId: Long?): ResultVO

    @GetMapping("$PREFIX/last/{appName}/{profile}")
    fun publishedLast(@PathVariable("appName") appName: String, @PathVariable("profile") profile: String): ResultVO

    @GetMapping("$PREFIX/last/{appId}")
    fun publishedLast(@PathVariable("appId") appId: Long?): ResultVO
}
