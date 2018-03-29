package io.gitee.zicai.test.controller

import io.gite.zicai.domain.Published
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

/**
 * RibbonController
 * @author zicai
 * @since 2018-03-29
 */
@RestController
@RequestMapping("/ribbon")
open class RibbonController {

    @Autowired
    private lateinit var balanceTemplate: RestTemplate

    @GetMapping("/last")
    fun last() = balanceTemplate.getForObject("http://zicai-config-server/published/last", Published::class.java)

}