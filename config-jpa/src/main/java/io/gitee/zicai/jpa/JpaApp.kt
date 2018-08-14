package io.gitee.zicai.jpa

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.transaction.annotation.EnableTransactionManagement

@SpringBootApplication
@EnableTransactionManagement
@EntityScan(basePackages = ["io.gitee.zicai.core.entity"])
open class JpaApp {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(JpaApp::class.java, *args)
        }
    }
}
