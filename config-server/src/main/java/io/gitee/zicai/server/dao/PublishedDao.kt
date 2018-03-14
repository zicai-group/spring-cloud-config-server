package io.gitee.zicai.server.dao

import io.gite.zicai.domain.Published
import org.joda.time.format.DateTimeFormat
import org.springframework.stereotype.Component

@Component
open class PublishedDao : AbstractDao<Published>() {

    override fun insert(entity: Published) {
        val sql = "insert into published (app_name, publish_time) values (?, ?)"
        jdbc.update(sql, entity.appName, entity.publishTime)
    }

    open fun getLast(): Published? {
        val sql = "select * from published order by publish_time desc limit 1"
        return jdbc.queryForMap(sql)?.let { Published(
                it["id"].toString().toInt(),
                it["app_name"].toString(),
                DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.S").parseDateTime(it["publish_time"].toString()).toDate()
        ) }
    }
}