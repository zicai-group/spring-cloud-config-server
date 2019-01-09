package io.gitee.zicai.client.sync

import io.gitee.zicai.core.entity.Published
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.scheduling.concurrent.CustomizableThreadFactory
import org.springframework.web.client.RestTemplate
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import javax.annotation.PostConstruct
import javax.annotation.PreDestroy

open class SyncConfig(
        private var balanceTemplate: RestTemplate,
        private var restTemplate: RestTemplate,
        private var syncConfigProperties: SyncConfigProperties) {

    private val log = LoggerFactory.getLogger(SyncConfig::class.java)

    private val executor = Executors.newSingleThreadScheduledExecutor(CustomizableThreadFactory("config-sync-pool-"))

    @Volatile
    private var currPublished: Published? = null

    @Synchronized
    private fun getLast() {
        var lastPublished: Published? = null
        try {
            log.debug(">>> get lastPublished")
            val rest = if (syncConfigProperties.discovery) balanceTemplate else restTemplate
            lastPublished = rest.getForObject(syncConfigProperties.syncUri, Published::class.java)
        } catch (e: Exception) {
            log.warn(">>> get lastPublished error -> ${e.message}")
        }
        lastPublished ?: return
        if (currPublished != null && !currPublished!!.publishTime!!.before(lastPublished.publishTime)) {
            return
        }
        if (refresh()) {
            currPublished = lastPublished
            log.debug(">>> refresh ok")
        } else {
            log.debug(">>> refresh fail")
        }
    }

    private fun refresh(): Boolean {
        var ok = false
        try {
            val res = restTemplate.postForEntity(syncConfigProperties.refreshUri, null, Any::class.java)
            log.debug(">>> do refresh")
            ok = res.statusCode == HttpStatus.OK
            log.debug(">>> changed -> ${res.body}")
        } catch (e: Exception) {
            log.warn(">>> refresh error -> ${e.message}")
        }
        return ok
    }

    @PostConstruct
    open fun before() {
        executor.scheduleWithFixedDelay(::getLast, syncConfigProperties.delayTime, syncConfigProperties.delayTime, TimeUnit.MILLISECONDS)
    }

    @PreDestroy
    open fun destroy() {
        executor?.shutdown()
    }
}