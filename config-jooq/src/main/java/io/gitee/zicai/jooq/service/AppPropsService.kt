package io.gitee.zicai.jooq.service

import io.gitee.zicai.jooq.gen.Tables
import org.springframework.stereotype.Service

@Service
open class AppPropsService : BaseService() {

    open fun findProps(appName: String, appEnv: String): Map<String, Any> {
        return jooq.select(Tables.APP_PROPS.PROP_KEY, Tables.APP_PROPS.PROP_VALUE)
                .from(Tables.APP_PROPS)
                .leftJoin(Tables.APP).on(Tables.APP_PROPS.APP_ID.eq(Tables.APP.ID))
                .where(Tables.APP.APP_NAME.eq(appName)).and(Tables.APP.APP_ENV.eq(appEnv))
                .fetch()
                .intoMap(Tables.APP_PROPS.PROP_KEY, Tables.APP_PROPS.PROP_VALUE)
    }
}
