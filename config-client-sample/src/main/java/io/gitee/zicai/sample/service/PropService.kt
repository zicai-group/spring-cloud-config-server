package io.gitee.zicai.sample.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.stereotype.Component

@Component
@RefreshScope
open class PropService {

    @Value("\${k_a}")
    private lateinit var a: String
    @Value("\${k_b}")
    private lateinit var b: String

    open fun getProps() = "k_a = $a, k_b = $b"
}