package io.gitee.zicai.server.dao

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate

abstract class AbstractDao<T> {

    @Autowired
    protected lateinit var jdbc: JdbcTemplate

    abstract fun insert(entity: T)
}