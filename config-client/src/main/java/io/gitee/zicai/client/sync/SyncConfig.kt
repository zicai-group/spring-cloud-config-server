package io.gitee.zicai.client.sync

import io.gite.zicai.domain.Published
import org.springframework.http.HttpStatus
import org.springframework.scheduling.concurrent.CustomizableThreadFactory
import org.springframework.web.client.RestTemplate
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

open class SyncConfig(private var rest: RestTemplate) {

    private val executor = Executors.newSingleThreadScheduledExecutor(CustomizableThreadFactory("sync-schedule"))

    private val delayTime = 3000.toLong()

    private val syncUrl = "http://localhost:8888/published/last"

    private @Volatile var currPublished: Published? = null

    init {
        executor.scheduleWithFixedDelay(::getLast, delayTime, delayTime, TimeUnit.MILLISECONDS)
    }

    private @Synchronized fun getLast() {
        var lastPublished: Published? = null
        try {
            System.err.println(">>> get lastPublished")
            lastPublished = rest.getForObject(syncUrl, Published::class.java)
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

    private val refreshUrl = "http://localhost:8899/refresh"

    private fun refresh(): Boolean {
        var ok = false
        try {
            val res = rest.postForEntity(refreshUrl, null, Any::class.java)
            System.err.println(">>> do refresh")
            ok = res.statusCode == HttpStatus.OK
        } catch (e: Exception) {
            System.err.println(">>> refresh error -> ${e.message}")
        }
        return ok
    }
}