package io.gitee.zicai.server

import io.gitee.zicai.biz.service.AppPropsService
import io.gitee.zicai.server.config.JdbcEnvironmentRepository
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.config.server.EnableConfigServer
import org.springframework.context.annotation.Bean
import org.springframework.transaction.annotation.EnableTransactionManagement
import tk.mybatis.spring.annotation.MapperScan

@SpringBootApplication(scanBasePackages = ["io.gitee.zicai.server", "io.gitee.zicai.biz.service"])
@EnableDiscoveryClient
@EnableConfigServer
@EnableTransactionManagement
@MapperScan("io.gitee.zicai.core.mapper")
open class App {

    @Bean
    open fun jdbcEnvironmentRepository(appPropsService: AppPropsService) = JdbcEnvironmentRepository(appPropsService)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(App::class.java, *args)
        }
    }
}
