package io.gitee.zicai.core.entity

import java.util.*

class Published : BaseEntity() {

    /**
     * 获取应用id
     *
     * @return app_id - 应用id
     */
    var appId: Long? = null

    /**
     * 获取发布内容
     *
     * @return props_data - 发布内容
     */
    var propsData: String? = null

    /**
     * 获取发布时间
     *
     * @return publish_time - 发布时间
     */
    var publishTime: Date? = null
}