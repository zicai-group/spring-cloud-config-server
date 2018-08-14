package io.gitee.zicai.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "published")
public class Published extends BaseEntity {

    /**
     * 应用id
     */
    @Column(name = "app_id")
    private Long appId;

    /**
     * 发布内容
     */
    @Column(name = "props_data")
    private String propsData;

    /**
     * 发布时间
     */
    @Column(name = "publish_time")
    private Date publishTime;

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
     * 获取发布内容
     *
     * @return props_data - 发布内容
     */
    public String getPropsData() {
        return propsData;
    }

    /**
     * 设置发布内容
     *
     * @param propsData 发布内容
     */
    public void setPropsData(String propsData) {
        this.propsData = propsData == null ? null : propsData.trim();
    }

    /**
     * 获取发布时间
     *
     * @return publish_time - 发布时间
     */
    public Date getPublishTime() {
        return publishTime;
    }

    /**
     * 设置发布时间
     *
     * @param publishTime 发布时间
     */
    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }
}