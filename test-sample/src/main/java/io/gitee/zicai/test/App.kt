package io.gitee.zicai.test

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

/**
 * App
 * @author zicai
 * @since 2018-03-29
 */
@SpringBootApplication
@EnableDiscoveryClient
open class App {

    @Bean
    @LoadBalanced
    open fun balanceTemplate() = RestTemplate()

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(App::class.java, *args)
        }
    }
}