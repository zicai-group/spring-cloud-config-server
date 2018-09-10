package io.gitee.zicai.jooq.service

import org.jooq.DSLContext
import org.springframework.beans.factory.annotation.Autowired

abstract class BaseService {

    @Autowired
    protected lateinit var jooq: DSLContext
}
