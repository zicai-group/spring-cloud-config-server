package io.gitee.zicai.server

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.config.server.EnableConfigServer

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
open class App {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(App::class.java, *args)
        }
    }
}
