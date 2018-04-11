package io.gitee.zicai.biz.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.gitee.zicai.core.entity.App;
import io.gitee.zicai.core.entity.Published;
import io.gitee.zicai.biz.mapper.PublishedMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.Map;

@Service
public class PublishedService extends BaseService<PublishedMapper, Published> {

    @Autowired
    private AppService appService;
    @Autowired
    private AppPropsService appPropsService;

    public int insert(String appName, String appEnv) {
        App app = appService.findOne(appName, appEnv);
        if (app == null) {
            return 0;
        }

        Map<String, Object> props = appPropsService.findProps(appName, appEnv);
        if (CollectionUtils.isEmpty(props)) {
            return 0;
        }

        Published entity = new Published();
        entity.setAppId(app.getId());
        entity.setPublishTime(new Date());
        try {
            entity.setPropsData(new ObjectMapper().writeValueAsString(props));
        } catch (JsonProcessingException ignored) {}

        return this.insert(entity);
    }

    public Published getLast(String appName, String appEnv) {
        return mapper.getLast(appName, appEnv);
    }
}
