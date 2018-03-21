package io.gitee.zicai.client.config

import io.gitee.zicai.client.sync.SyncConfig
import io.gitee.zicai.client.sync.SyncConfigProperties
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
@EnableConfigurationProperties(SyncConfigProperties::class)
open class ConfigClientAutoConfiguration {

    @Bean
    @LoadBalanced
    @ConditionalOnProperty(name = ["config.sync.discovery"], havingValue = "true")
    open fun balanceTemplate() = RestTemplate()

    @Bean
    open fun restTemplate() = RestTemplate()

    @Bean
    open fun syncConfig(balanceTemplate: RestTemplate, restTemplate: RestTemplate, syncConfigProperties: SyncConfigProperties) =
            SyncConfig(balanceTemplate, restTemplate, syncConfigProperties)

}