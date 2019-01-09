package io.gitee.zicai.core.entity

class AppProps : BaseEntity() {

    /**
     * 获取应用id
     *
     * @return app_id - 应用id
     */
    var appId: Long? = null

    /**
     * 获取参数名
     *
     * @return prop_key - 参数名
     */
    var propKey: String? = null

    /**
     * 获取参数值
     *
     * @return prop_value - 参数值
     */
    var propValue: String? = null
}