package io.gitee.zicai.client.sync

import io.gite.zicai.domain.Published
import org.springframework.http.HttpStatus
import org.springframework.scheduling.concurrent.CustomizableThreadFactory
import org.springframework.web.client.RestTemplate
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

open class SyncConfig(
        private var balanceTemplate: RestTemplate,
        private var restTemplate: RestTemplate,
        private var syncConfigProperties: SyncConfigProperties) {

    private val executor = Executors.newSingleThreadScheduledExecutor(CustomizableThreadFactory("sync-schedule"))

    @Volatile
    private var currPublished: Published? = null

    init {
        executor.scheduleWithFixedDelay(::getLast, syncConfigProperties.delayTime, syncConfigProperties.delayTime, TimeUnit.MILLISECONDS)
    }

    @Synchronized
    private fun getLast() {
        var lastPublished: Published? = null
        try {
            System.err.println(">>> get lastPublished")
            val rest = if (syncConfigProperties.discovery) balanceTemplate else restTemplate
            lastPublished = rest.getForObject(syncConfigProperties.syncUri, Published::class.java)
        } catch (e: Exception) {
            System.err.println(">>> get lastPublished error -> ${e.message}")
        }
        if (lastPublished == null) {
            return
        }
        if (currPublished != null && currPublished!!.id >= lastPublished.id) {
            return
        }
        if (refresh()) {
            currPublished = lastPublished
            System.err.println(">>> refresh ok")
        } else {
            System.err.println(">>> refresh fail")
        }
    }

    private fun refresh(): Boolean {
        var ok = false
        try {
            val res = restTemplate.postForEntity(syncConfigProperties.refreshUri, null, Any::class.java)
            System.err.println(">>> do refresh")
            ok = res.statusCode == HttpStatus.OK
        } catch (e: Exception) {
            System.err.println(">>> refresh error -> ${e.message}")
        }
        return ok
    }
}