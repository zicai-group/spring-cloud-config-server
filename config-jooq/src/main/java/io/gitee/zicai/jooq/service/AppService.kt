package io.gitee.zicai.jooq.service

import io.gitee.zicai.core.entity.App
import io.gitee.zicai.jooq.gen.Tables
import org.springframework.stereotype.Service

@Service
open class AppService : BaseService() {

    open fun findById(appId: Long): App = jooq.selectFrom(Tables.APP)
            .where(Tables.APP.ID.eq(appId))
            .fetchOneInto(App::class.java)

    open fun findOne(appName: String, appEnv: String): App {

        return jooq.selectFrom(Tables.APP)
                .where(Tables.APP.APP_NAME.eq(appName).and(Tables.APP.APP_ENV.eq(appEnv)))
                .fetchOneInto(App::class.java)
    }

}
