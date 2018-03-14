package io.gitee.zicai.server

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.config.server.EnableConfigServer

@SpringBootApplication
@EnableConfigServer
open class App

fun main(args: Array<String>) {
    SpringApplication.run(App::class.java, *args)
}