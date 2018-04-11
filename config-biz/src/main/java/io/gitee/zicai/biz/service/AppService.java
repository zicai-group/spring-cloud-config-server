package io.gitee.zicai.biz.service;

import io.gitee.zicai.core.entity.App;
import io.gitee.zicai.biz.mapper.AppMapper;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.weekend.Weekend;

@Service
public class AppService extends BaseService<AppMapper, App> {

    public App findOne(String appName, String appEnv) {
        Weekend<App> weekend = new Weekend<>(App.class);
        weekend.weekendCriteria().andEqualTo(App::getAppName, appName).andEqualTo(App::getAppEnv, appEnv);

        return mapper.selectOneByExample(weekend);
    }
}
