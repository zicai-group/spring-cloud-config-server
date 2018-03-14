package io.gitee.zicai.client.config

import io.gitee.zicai.client.sync.SyncConfig
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
open class ConfigClientAutoConfiguration {

    @Bean
    open fun restTemplate() = RestTemplate()

    @Bean
    open fun syncConfig(rest: RestTemplate) = SyncConfig(rest)

}