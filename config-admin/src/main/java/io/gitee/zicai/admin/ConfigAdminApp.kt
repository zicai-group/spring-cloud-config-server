package io.gitee.zicai.admin

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.cloud.netflix.feign.EnableFeignClients
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
open class ConfigAdminApp {

    @Bean
    @LoadBalanced
    open fun balanceTemplate() = RestTemplate()

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(ConfigAdminApp::class.java, *args)
        }
    }
}