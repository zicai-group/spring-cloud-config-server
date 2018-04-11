package io.gitee.zicai.core.entity;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "app")
public class App extends BaseEntity {

    /**
     * 应用名
     */
    @Column(name = "app_name")
    private String appName;

    /**
     * 配置环境
     */
    @Column(name = "app_env")
    private String appEnv;

    /**
     * 获取应用名
     *
     * @return app_name - 应用名
     */
    public String getAppName() {
        return appName;
    }

    /**
     * 设置应用名
     *
     * @param appName 应用名
     */
    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    /**
     * 获取配置环境
     *
     * @return app_env - 配置环境
     */
    public String getAppEnv() {
        return appEnv;
    }

    /**
     * 设置配置环境
     *
     * @param appEnv 配置环境
     */
    public void setAppEnv(String appEnv) {
        this.appEnv = appEnv == null ? null : appEnv.trim();
    }
}