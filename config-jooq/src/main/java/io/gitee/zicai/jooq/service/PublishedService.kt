package io.gitee.zicai.jooq.service

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import io.gitee.zicai.core.entity.App
import io.gitee.zicai.core.entity.Published
import io.gitee.zicai.jooq.gen.Tables
import io.gitee.zicai.jooq.gen.tables.records.PublishedRecord
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.util.CollectionUtils
import java.sql.Timestamp
import java.util.*

@Service
open class PublishedService : BaseService() {

    @Autowired
    private lateinit var appService: AppService
    @Autowired
    private lateinit var appPropsService: AppPropsService

    open fun insert(appId: Long): Published? {
        val app = appService.findById(appId)
        return this.insert(app)
    }

    open fun insert(appName: String, appEnv: String): Published? {
        val app = appService.findOne(appName, appEnv)
        return this.insert(app)
    }

    private fun insert(app: App): Published? {
        val props = appPropsService.findProps(app.appName!!, app.appEnv!!)
        if (CollectionUtils.isEmpty(props)) {
            return null
        }

        val entity = PublishedRecord()
        entity.appId = app.id
        entity.publishTime = Timestamp.from(Date().toInstant())
        try {
            entity.propsData = ObjectMapper().writeValueAsString(props)
        } catch (ignored: JsonProcessingException) {
        }

        val t = Tables.PUBLISHED
        jooq.insertInto(t).set(entity).execute()
        return entity.into(Published::class.java)
    }

    open fun getLast(appName: String, appEnv: String): Published? {
        val q = Tables.PUBLISHED
        val qApp = Tables.APP
        return jooq.select(*q.fields())
                .from(q)
                .leftJoin(qApp).on(q.APP_ID.eq(qApp.ID))
                .where(qApp.APP_NAME.eq(appName).and(qApp.APP_ENV.eq(appEnv)))
                .orderBy(q.PUBLISH_TIME.desc())
                .limit(1)
                .fetchOneInto(Published::class.java)
    }

    open fun getLast(appId: Long): Published? {
        val q = Tables.PUBLISHED
        return jooq.selectFrom(q)
                .where(q.APP_ID.eq(appId))
                .orderBy(q.PUBLISH_TIME.desc())
                .limit(1)
                .fetchOneInto(Published::class.java)
    }
}
