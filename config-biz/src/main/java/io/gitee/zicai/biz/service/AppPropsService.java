package io.gitee.zicai.biz.service;

import io.gitee.zicai.core.entity.AppProps;
import io.gitee.zicai.biz.mapper.AppPropsMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AppPropsService extends BaseService<AppPropsMapper, AppProps> {

    public Map<String, Object> findProps(String appName, String appEnv) {
        List<AppProps> list = mapper.findProps(appName, appEnv);

        if (CollectionUtils.isEmpty(list)) {
            return new HashMap<>();
        }

        return list.stream().collect(Collectors.toMap(AppProps::getPropKey, AppProps::getPropValue, (l, r) -> r));
    }
}
