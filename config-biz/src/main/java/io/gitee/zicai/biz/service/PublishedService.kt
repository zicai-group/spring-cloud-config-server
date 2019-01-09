package io.gitee.zicai.biz.service

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import io.gitee.zicai.biz.mapper.PublishedMapper
import io.gitee.zicai.core.entity.App
import io.gitee.zicai.core.entity.Published
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.util.CollectionUtils
import java.util.*

@Service
open class PublishedService : BaseService<PublishedMapper, Published>() {

    @Autowired
    private lateinit var appService: AppService
    @Autowired
    private lateinit var appPropsService: AppPropsService

    open fun insert(appId: Long?): Int {
        val app = appService.selectByPrimaryKey(appId)
        return this.insert(app)
    }

    open fun insert(appName: String, appEnv: String): Int {
        val app = appService.findOne(appName, appEnv)
        return this.insert(app)
    }

    private fun insert(app: App): Int {
        val props = appPropsService.findProps(app.appName!!, app.appEnv!!)
        if (CollectionUtils.isEmpty(props)) {
            return 0
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

    open fun getLast(appName: String, appEnv: String): Published {
        return baseMapper.getLast(appName, appEnv)
    }

    open fun getLast(appId: Long?): Published {
        return baseMapper.getLastOne(appId)
    }
}
