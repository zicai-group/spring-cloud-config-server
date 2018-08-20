package io.gitee.zicai.jpa.service

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import io.gitee.zicai.core.entity.App
import io.gitee.zicai.core.entity.Published
import io.gitee.zicai.core.entity.QApp
import io.gitee.zicai.core.entity.QPublished
import io.gitee.zicai.jpa.repo.PublishedRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.util.CollectionUtils
import java.util.*

@Service
open class PublishedService : BaseService<PublishedRepo, Published>() {

    @Autowired
    private lateinit var appService: AppService
    @Autowired
    private lateinit var appPropsService: AppPropsService

    open fun insert(appId: Long): Published? {
        val app = appService.selectById(appId)
        return this.insert(app)
    }

    open fun insert(appName: String, appEnv: String): Published? {
        val app = appService.findOne(appName, appEnv)
        return this.insert(app)
    }

    private fun insert(app: App): Published? {
        val props = appPropsService.findProps(app.appName, app.appEnv)
        if (CollectionUtils.isEmpty(props)) {
            return null
        }

        val entity = Published()
        entity.appId = app.id
        entity.publishTime = Date()
        try {
            entity.propsData = ObjectMapper().writeValueAsString(props)
        } catch (ignored: JsonProcessingException) {
        }

        return this.insert(entity)
    }

    open fun getLast(appName: String, appEnv: String): Published? {
        val q = QPublished.published
        val qApp = QApp.app
        return jpaQuery.select(q)
                .from(q, qApp)
                .where(q.appId.eq(qApp.id).and(qApp.appName.eq(appName)).and(qApp.appEnv.eq(appEnv)))
                .orderBy(q.publishTime.desc())
                .limit(1)
                .fetchOne()
        // leftJoin 需要 entity 中配置 @OneToOne 之类的关系，所以不用
//        return jpaQuery.selectFrom(q)
//                .leftJoin(qApp).on(q.appId.eq(qApp.id))
//                .where(qApp.appName.eq(appName).and(qApp.appEnv.eq(appEnv)))
//                .orderBy(q.publishTime.desc())
//                .limit(1)
//                .fetchOne()
    }

    open fun getLast(appId: Long): Published? {
        val q = QPublished.published
        return jpaQuery.selectFrom(q)
                .where(q.appId.eq(appId))
                .orderBy(q.publishTime.desc())
                .limit(1)
                .fetchOne()
    }
}
