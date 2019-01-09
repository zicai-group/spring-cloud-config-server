package io.gitee.zicai.core.entity

class App : BaseEntity() {

    /**
     * 获取应用名
     *
     * @return app_name - 应用名
     */
    var appName: String? = null

    /**
     * 获取配置环境
     *
     * @return app_env - 配置环境
     */
    var appEnv: String? = null
}