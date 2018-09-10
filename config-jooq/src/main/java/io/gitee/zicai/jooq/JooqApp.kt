package io.gitee.zicai.jooq

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.transaction.annotation.EnableTransactionManagement

@SpringBootApplication
@EnableTransactionManagement
open class JooqApp {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(JooqApp::class.java, *args)
        }
    }
}
