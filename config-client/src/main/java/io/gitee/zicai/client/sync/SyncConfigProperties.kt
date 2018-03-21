package io.gitee.zicai.client.sync

import org.springframework.boot.context.properties.ConfigurationProperties

/**
 * SyncConfigProperties
 * @author zicai
 * @since 2018-03-21
 */
@ConfigurationProperties("config.sync")
open class SyncConfigProperties {

    var discovery: Boolean = false

    var syncUri: String = "http://localhost:8888"

    var serverPort: String = "8080"

    var refreshUri: String = "http://localhost:$serverPort/refresh"
        get() = "http://localhost:$serverPort/refresh"

    var delayTime: Long = 3000
}