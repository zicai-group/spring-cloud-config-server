package io.gitee.zicai.sample

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
open class App

fun main(args: Array<String>) {
    SpringApplication.run(App::class.java, *args)
}