package io.gitee.zicai.sample.controller

import io.gite.zicai.domain.Published
import io.gitee.zicai.client.sync.SyncConfigProperties
import io.gitee.zicai.sample.service.PropService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RequestMapping("/props")
@RestController
open class PropsController {

    @Autowired
    private lateinit var propService: PropService
    @Autowired
    private var balanceTemplate: RestTemplate? = null
    @Autowired
    private lateinit var syncConfigProperties: SyncConfigProperties

    @GetMapping("/get")
    open fun getProps() = propService.getProps()

    @GetMapping("/last")
    open fun getLast() = balanceTemplate?.getForObject(syncConfigProperties.syncUri, Published::class.java) ?: Published(appName = "nonBalance")

}