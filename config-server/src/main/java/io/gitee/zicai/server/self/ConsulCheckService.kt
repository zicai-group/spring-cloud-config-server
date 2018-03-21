package io.gitee.zicai.server.self

import com.ecwid.consul.v1.ConsulClient
import com.ecwid.consul.v1.QueryParams
import com.ecwid.consul.v1.health.model.Check
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.scheduling.concurrent.CustomizableThreadFactory
import org.springframework.stereotype.Component
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

/**
 * ConsulCheckService
 * @author zicai
 * @since 2018-03-21
 */
@Component
open class ConsulCheckService {

    @Autowired
    private lateinit var consulClient: ConsulClient

    @Value("\${spring.application.name}")
    private lateinit var appName: String

    private val executor = Executors.newSingleThreadScheduledExecutor(CustomizableThreadFactory("consul-clear"))

    init {
        executor.scheduleWithFixedDelay({ check() }, 30000, 30000, TimeUnit.MILLISECONDS)
    }

    private fun check() {
        System.err.println(">>> consul services check.")
        val res = consulClient.getHealthServices(appName, false, QueryParams.DEFAULT)
        if (res == null || res.value.isEmpty()) {
            return
        }
        res.value.forEach {
            val clearClient = ConsulClient(it.node.address)
            it.checks.filter { it.status != Check.CheckStatus.PASSING }
                    .map { it.serviceId }
                    .forEach {
                        clearClient.agentServiceDeregister(it)
                        System.err.println(">>> Deregister $it")
                    }
        }
    }
}