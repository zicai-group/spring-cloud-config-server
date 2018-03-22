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

    var refreshUri: String = "http://localhost:8080/refresh"

    var delayTime: Long = 3000
}