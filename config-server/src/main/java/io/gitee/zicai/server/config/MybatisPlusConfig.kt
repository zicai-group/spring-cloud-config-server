package io.gitee.zicai.server.config

import org.mybatis.spring.annotation.MapperScan
import org.springframework.context.annotation.Configuration

/**
 * MybatisPlusConfig
 *
 * @author zicai
 * @since 2019-01-09
 */
@Configuration
@MapperScan("io.gitee.zicai.biz.mapper")
open class MybatisPlusConfig {
}