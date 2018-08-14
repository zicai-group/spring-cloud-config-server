package io.gitee.zicai.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "app_props")
public class AppProps extends BaseEntity {

    /**
     * 应用id
     */
    @Column(name = "app_id")
    private Long appId;

    /**
     * 参数名
     */
    @Column(name = "prop_key")
    private String propKey;

    /**
     * 参数值
     */
    @Column(name = "prop_value")
    private String propValue;

    /**
     * 获取应用id
     *
     * @return app_id - 应用id
     */
    public Long getAppId() {
        return appId;
    }

    /**
     * 设置应用id
     *
     * @param appId 应用id
     */
    public void setAppId(Long appId) {
        this.appId = appId;
    }

    /**
     * 获取参数名
     *
     * @return prop_key - 参数名
     */
    public String getPropKey() {
        return propKey;
    }

    /**
     * 设置参数名
     *
     * @param propKey 参数名
     */
    public void setPropKey(String propKey) {
        this.propKey = propKey == null ? null : propKey.trim();
    }

    /**
     * 获取参数值
     *
     * @return prop_value - 参数值
     */
    public String getPropValue() {
        return propValue;
    }

    /**
     * 设置参数值
     *
     * @param propValue 参数值
     */
    public void setPropValue(String propValue) {
        this.propValue = propValue == null ? null : propValue.trim();
    }
}