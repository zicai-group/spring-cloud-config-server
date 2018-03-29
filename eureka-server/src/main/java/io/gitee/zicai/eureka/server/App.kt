package io.gitee.zicai.eureka.server

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

/**
 * App
 * @author zicai
 * @since 2018-03-29
 */
@SpringBootApplication
@EnableEurekaServer
open class App {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(App::class.java, *args)
        }
    }
}